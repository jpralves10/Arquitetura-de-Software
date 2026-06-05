package com.livro.ofertas.gubee.resouce;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.Pedido;
import com.livro.ofertas.gubee.model.PedidoCompleto;
import com.livro.ofertas.gubee.resource.PedidoResource;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import com.livro.ofertas.gubee.service.Impl.PedidoServiceImpl;
import com.livro.ofertas.gubee.service.Impl.RedisServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(PedidoResource.class)
public class PedidoResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PedidoServiceImpl pedidoService;

    @MockitoBean
    private RedisServiceImpl serviceRedis;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void dadoNovoPedido_quandoCadastrar_entaoRetornarCreated() throws Exception {

        Cliente clienteSalvo = new Cliente(1, "João");
        Mockito.when(pedidoService.salvarPedido(any(PedidoCompleto.class))).thenReturn(clienteSalvo.getNome());
    }

    @Test
    public void obterPedido_quandoCadastrar_entaoRetornarCreated() throws Exception {

        PedidoCompleto pedidoCompleto = new PedidoCompleto(1, 1, new ArrayList<>());
        Mockito.when(pedidoService.buscarPedido(any(Integer.class))).thenReturn(pedidoCompleto);
    }
}
