package com.livro.ofertas.gubee.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void init() {
        cliente = new Cliente(1, "João");
    }

    @Test
    void testSetNome() {
        cliente.setNome("Jane");
        Assertions.assertEquals("Jane", cliente.getNome(), "The name should be Jane");
    }
}
