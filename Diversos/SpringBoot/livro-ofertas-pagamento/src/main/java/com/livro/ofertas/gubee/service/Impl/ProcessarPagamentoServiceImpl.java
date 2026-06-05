package com.livro.ofertas.gubee.service.Impl;

import com.livro.ofertas.gubee.model.KafkaModel;
import com.livro.ofertas.gubee.service.ProcessarPagamentoService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProcessarPagamentoServiceImpl implements ProcessarPagamentoService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProcessarPagamentoServiceImpl.class);

    @Autowired
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Value("${kafka.producer.topic-name}")
    private String producerTopic;

    @Value("${kafka.environment}")
    private String KAFKA_ENV;

    @KafkaListener(topics = "${kafka.consumer.topic-name}", groupId = "group_id")
    public void processarPagamento(ConsumerRecord<String, KafkaModel> payload){
        LOGGER.info("key: {}", payload.key());
        LOGGER.info("Headers: {}", payload.headers());
        LOGGER.info("Partion: {}", payload.partition());
        LOGGER.info("Model: {}", payload.value());
    }
}
