package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.KafkaModel;
import org.springframework.http.ResponseEntity;

public interface ProcessarPedidoService {

    void processarPedido();

    ResponseEntity<Object> producerKafka(KafkaModel kafkaModel);
}
