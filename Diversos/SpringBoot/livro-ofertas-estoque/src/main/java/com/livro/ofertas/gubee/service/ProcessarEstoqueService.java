package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.KafkaModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ProcessarEstoqueService {

    void processarEstoque(ConsumerRecord<String, KafkaModel> payload);
}
