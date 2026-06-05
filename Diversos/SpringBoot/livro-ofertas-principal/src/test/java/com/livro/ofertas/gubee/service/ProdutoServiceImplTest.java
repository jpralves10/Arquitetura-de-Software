package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.Produto;
import com.livro.ofertas.gubee.repository.ClienteRepository;
import com.livro.ofertas.gubee.repository.ProdutoRepository;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import com.livro.ofertas.gubee.service.Impl.ProdutoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    ProdutoServiceImpl service;

    @Test
    public void buscarProdutoPorId() {

        Produto produto = new Produto(1, "Motor 2.0", 1200.0f );

        Mockito.when(repository.getReferenceById(any(Integer.class))).thenReturn(produto);

        service.buscarProdutoPorId(1);
    }

    @Test
    public void salvarProduto() {

        Produto produto = new Produto(1, "Motor 2.0", 1200.0f );

        Mockito.when(repository.save(any(Produto.class))).thenReturn(produto);

        service.salvarProduto(produto);
    }
}
