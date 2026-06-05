package com.livro.ofertas.gubee.resouce;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.Produto;
import com.livro.ofertas.gubee.resource.PedidoResource;
import com.livro.ofertas.gubee.resource.ProdutoResource;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import com.livro.ofertas.gubee.service.Impl.ProdutoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(ProdutoResource.class)
public class ProdutoResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProdutoServiceImpl produtoService;

    @Test
    public void dadoNovoProduto_quandoCadastrar_entaoRetornarCreated() throws Exception {

        Produto produto = new Produto(1, "Vibranium", 10.0f);
        Mockito.when(produtoService.salvarProduto(any(Produto.class))).thenReturn(produto.getNome());
    }

    @Test
    public void obterProduto_quandoCadastrar_entaoRetornarCreated() throws Exception {

        Produto produto = new Produto(1, "Vibranium", 10.0f);
        Mockito.when(produtoService.buscarProdutoPorId(any(Integer.class))).thenReturn(produto);
    }
}
