package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void buscarCliente() {

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Maria");
        entityManager.persist(cliente);

        Optional<Cliente> resultado = clienteRepository.findById(1);

        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Maria");
    }

    @Test
    void deveRetornarVazioAoBuscarClienteInexistente() {
        Optional<Cliente> resultado = clienteRepository.findById(12);
        assertThat(resultado).isNotPresent();
    }
}
