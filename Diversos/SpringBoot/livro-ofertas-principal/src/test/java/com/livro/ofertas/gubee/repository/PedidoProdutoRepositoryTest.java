package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.PedidoProduto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PedidoProdutoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    @Test
    void buscarPedidoProduto() {

        PedidoProduto pedidoProduto = new PedidoProduto();
        pedidoProduto.setIdPedido("1");
        pedidoProduto.setIdProduto("1");
        pedidoProduto.setQuantidade(3);
        pedidoProduto.setValor(15.2f);
        entityManager.persist(pedidoProduto);

        Optional<PedidoProduto> resultado = pedidoProdutoRepository.findById(1);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getQuantidade()).isEqualTo(3);
    }

    @Test
    void deveRetornarVazioAoBuscarPedidoProdutoInexistente() {
        Optional<PedidoProduto> resultado = pedidoProdutoRepository.findById(12);
        assertThat(resultado).isNotPresent();
    }
}
