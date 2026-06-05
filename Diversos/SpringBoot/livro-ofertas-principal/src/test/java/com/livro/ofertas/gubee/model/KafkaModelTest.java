package com.livro.ofertas.gubee.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KafkaModelTest {

    private KafkaModel kafkaModel;

    @BeforeEach
    void init() {
        kafkaModel = new KafkaModel("Hoje");
    }

    @Test
    void testSetNome() {
        kafkaModel.setMessage("Amanhã");
        Assertions.assertEquals("Amanhã", kafkaModel.getMessage(), "The message should be Amanhã");
    }
}
