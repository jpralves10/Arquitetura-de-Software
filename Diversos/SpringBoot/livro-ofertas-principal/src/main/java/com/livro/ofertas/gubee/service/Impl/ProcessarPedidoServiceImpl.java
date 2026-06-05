package com.livro.ofertas.gubee.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livro.ofertas.gubee.config.LivroOfertaUtils;
import com.livro.ofertas.gubee.model.KafkaModel;
import com.livro.ofertas.gubee.model.Pedido;
import com.livro.ofertas.gubee.model.PedidoProduto;
import com.livro.ofertas.gubee.repository.PedidoProdutoRepository;
import com.livro.ofertas.gubee.repository.PedidoRepository;
import com.livro.ofertas.gubee.service.ProcessarPedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessarPedidoServiceImpl implements ProcessarPedidoService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProcessarPedidoServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoProdutoRepository pprepository;

    @Autowired
    private RedisServiceImpl serviceRedis;

    @Value("${kafka.producer.topic-name}")
    private String producerTopic;

    @Value("${kafka.environment}")
    private String KAFKA_ENV;

    @Scheduled(fixedRate = 5000)
    public void processarPedido() {

        KafkaModel kafkaModel = new KafkaModel();

        List<Pedido> pedidos = pedidoRepository.findByProcessado(false);

        Integer quantidade = 0;

        pedidos.forEach(pedido -> {

            List<PedidoProduto> produtos = pprepository.findByIdPedido(pedido.getId());

            ObjectMapper mapper = new ObjectMapper();

            Float valorPedido = 0.0f;

            try {
                String jsonString = mapper.writeValueAsString(produtos);
                kafkaModel.setMessage(jsonString);

                producerKafka(kafkaModel);

                valorPedido = LivroOfertaUtils.gerarValorPedido(produtos);

                String pedidoPayload = "Pedido: " + pedido.getId() + " Valor: " + valorPedido;

                serviceRedis.salvarDados(pedido.getId().toString(), pedidoPayload);

                System.out.println(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("Task executed at " + System.currentTimeMillis());
    }

    public ResponseEntity<Object> producerKafka(KafkaModel kafkaModel){

        kafkaTemplate.send(producerTopic, kafkaModel);

        return ResponseEntity.ok().build();
    }

    /*@KafkaListener(topics = "${kafka.consumer.topic-name}", groupId = "group_id")
    public void onReceiverTopicKafka(ConsumerRecord<String, KafkaModel> payload){
        LOGGER.info("key: {}", payload.key());
        LOGGER.info("Headers: {}", payload.headers());
        LOGGER.info("Partion: {}", payload.partition());
        LOGGER.info("Model: {}", payload.value());
    }*/
}
