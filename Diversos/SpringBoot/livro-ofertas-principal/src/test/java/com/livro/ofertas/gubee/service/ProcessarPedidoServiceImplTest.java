package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.KafkaModel;
import com.livro.ofertas.gubee.model.Pedido;
import com.livro.ofertas.gubee.model.PedidoProduto;
import com.livro.ofertas.gubee.repository.PedidoProdutoRepository;
import com.livro.ofertas.gubee.repository.PedidoRepository;
import com.livro.ofertas.gubee.service.Impl.ProcessarPedidoServiceImpl;
import com.livro.ofertas.gubee.service.Impl.RedisServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProcessarPedidoServiceImplTest {

    @Mock
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private PedidoProdutoRepository pprepository;

    @Mock
    private RedisServiceImpl serviceRedis;

    @InjectMocks
    ProcessarPedidoServiceImpl service;

    @Value("${kafka.producer.topic-name}")
    private String producerTopic;

    @Value("${kafka.environment}")
    private String KAFKA_ENV;

    @Test
    public void processarPedido() {

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(Pedido.builder().id(1).idCliente(1).processado(false).build());

        Mockito.when(pedidoRepository.findByProcessado(any(Boolean.class))).thenReturn(pedidos);

        Consumer<Pedido> mockedConsumer = Mockito.mock(Consumer.class);
        pedidos.forEach(mockedConsumer);

        Mockito.verify(mockedConsumer, Mockito.times(1)).accept(pedidos.get(0));

        List<PedidoProduto> produtos = new ArrayList<>();

        //Mockito.when(pprepository.findByIdPedido(any(Integer.class))).thenReturn(produtos);

        service.processarPedido();
    }
}
