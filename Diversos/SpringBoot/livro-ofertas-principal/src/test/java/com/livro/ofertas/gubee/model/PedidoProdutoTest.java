package com.livro.ofertas.gubee.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoProdutoTest {

    private PedidoProduto pedidoProduto;

    @BeforeEach
    void init() {
        pedidoProduto = new PedidoProduto("1", "1", 3, 250.0f);
    }

    @Test
    void testSetNome() {
        pedidoProduto.setQuantidade(5);
        Assertions.assertEquals(5, pedidoProduto.getQuantidade(), "The quantidade should be 5");
    }
}
