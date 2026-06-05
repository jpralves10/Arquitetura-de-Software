package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.Pedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
public class PedidoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void buscarPedidoNaoProcessado() {

        Pedido pedido = new Pedido();
        pedido.setId(1);
        pedido.setIdCliente(1);
        pedido.setProcessado(false);
        entityManager.persist(pedido);

        Optional<Pedido> resultado = pedidoRepository.findById(1);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getProcessado()).isEqualTo(false);
    }

    @Test
    void deveRetornarVazioAoBuscarPedidoInexistente() {
        Optional<Pedido> resultado = pedidoRepository.findById(12);
        assertThat(resultado).isNotPresent();
    }
}
