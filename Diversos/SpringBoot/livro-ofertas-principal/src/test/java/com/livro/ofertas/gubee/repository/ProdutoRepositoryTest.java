package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void buscarProduto() {

        Produto produto = new Produto();
        produto.setId(1);
        produto.setNome("Vibranium");
        produto.setPreco(10.0f);
        entityManager.persist(produto);

        Optional<Produto> resultado = produtoRepository.findById(1);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Vibranium");
    }

    @Test
    void deveRetornarVazioAoBuscarProdutoInexistente() {
        Optional<Produto> resultado = produtoRepository.findById(12);
        assertThat(resultado).isNotPresent();
    }
}
