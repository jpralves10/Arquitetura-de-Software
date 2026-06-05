package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.KafkaModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface ProcessarPagamentoService {

    void processarPagamento(ConsumerRecord<String, KafkaModel> payload);
}
