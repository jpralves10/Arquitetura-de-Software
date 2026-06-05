package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.model.Pedido;
import com.livro.ofertas.gubee.model.PedidoCompleto;
import com.livro.ofertas.gubee.model.PedidoProduto;
import com.livro.ofertas.gubee.repository.PedidoProdutoRepository;
import com.livro.ofertas.gubee.repository.PedidoRepository;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import com.livro.ofertas.gubee.service.Impl.PedidoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceImplTest {

    @Mock
    private PedidoRepository repository;

    @Mock
    PedidoProdutoRepository pprepository;

    @InjectMocks
    PedidoServiceImpl service;

    @Test
    public void salvarPedido() {

        Pedido pedido = new Pedido(1, 1, false);

        List<PedidoProduto> lista = new ArrayList<>();

        PedidoProduto pedidoProduto = PedidoProduto.builder()
                .idPedido("1")
                .idProduto("1")
                .quantidade(3)
                .valor(100.2f).build();

        Mockito.when(repository.save(any(Pedido.class))).thenReturn(pedido);

        //Mockito.when(pprepository.save(any(PedidoProduto.class))).thenReturn(pedidoProduto);

        service.salvarPedido(new PedidoCompleto());
    }

    @Test
    public void buscarPedido() {

        Pedido pedido = new Pedido(1, 1, false);

        List<PedidoProduto> lista = new ArrayList<>();

        Mockito.when(repository.getReferenceById(any(Integer.class))).thenReturn(pedido);

        Mockito.when(pprepository.findByIdPedido(any(Integer.class))).thenReturn(lista);

        service.buscarPedido(1);
    }
}
