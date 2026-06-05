package com.livro.ofertas.gubee.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    private Produto produto;

    @BeforeEach
    void init() {
        produto = new Produto(1, "Vibranium", 12.5f);
    }

    @Test
    void testSetNome() {
        produto.setNome("Vibranium 2.0");
        Assertions.assertEquals("Vibranium 2.0", produto.getNome(), "The name should be Vibranium 2.0");
    }
}
