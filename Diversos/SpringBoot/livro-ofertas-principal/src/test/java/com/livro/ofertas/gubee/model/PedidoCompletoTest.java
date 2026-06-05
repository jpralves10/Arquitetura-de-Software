package com.livro.ofertas.gubee.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PedidoCompletoTest {

    private PedidoCompleto pedidoCompleto;

    @BeforeEach
    void init() {
        pedidoCompleto = new PedidoCompleto(1, 1, new ArrayList<>());
    }

    @Test
    void testSetNome() {
        pedidoCompleto.setIdCliente(2);
        Assertions.assertEquals(2, pedidoCompleto.getIdCliente(), "The IdCliente should be 2");
    }
}
