package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.repository.ClienteRepository;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    ClienteServiceImpl service;

    @Test
    public void buscarClientePorId() {

        Cliente clienteSalvo = new Cliente(1, "João");

        Mockito.when(repository.getReferenceById(any(Integer.class))).thenReturn(clienteSalvo);

        service.buscarClientePorId(1);
    }

    @Test
    public void salvarCliente() {

        Cliente clienteSalvo = new Cliente(1, "João");

        Mockito.when(repository.save(any(Cliente.class))).thenReturn(clienteSalvo);

        service.salvarCliente(clienteSalvo);
    }
}
