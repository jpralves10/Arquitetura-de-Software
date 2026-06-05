package com.livro.ofertas.gubee.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void init() {
        pedido = new Pedido(1, 1, false);
    }

    @Test
    void testSetNome() {
        pedido.setProcessado(true);
        Assertions.assertEquals(true, pedido.getProcessado(), "The processado should be true");
    }
}
