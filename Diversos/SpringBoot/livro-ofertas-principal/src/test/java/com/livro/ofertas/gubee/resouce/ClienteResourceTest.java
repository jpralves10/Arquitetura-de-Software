package com.livro.ofertas.gubee.resouce;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.resource.ClienteResource;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(ClienteResource.class)
public class ClienteResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ClienteServiceImpl clienteService;

    @Test
    public void dadoNovoCliente_quandoCadastrar_entaoRetornarCreated() throws Exception {

        Cliente clienteSalvo = new Cliente(1, "João");
        Mockito.when(clienteService.salvarCliente(any(Cliente.class))).thenReturn(clienteSalvo.getNome());
    }

    @Test
    public void obterCliente_quandoCadastrar_entaoRetornarCreated() throws Exception {

        Cliente clienteSalvo = new Cliente(1, "João");
        Mockito.when(clienteService.buscarClientePorId(any(Integer.class))).thenReturn(clienteSalvo);
    }
}
