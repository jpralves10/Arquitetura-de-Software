package com.livro.ofertas.gubee.service.Impl;

import com.livro.ofertas.gubee.config.LivroOfertaUtils;
import com.livro.ofertas.gubee.model.Pedido;
import com.livro.ofertas.gubee.model.PedidoCompleto;
import com.livro.ofertas.gubee.model.PedidoProduto;
import com.livro.ofertas.gubee.repository.PedidoProdutoRepository;
import com.livro.ofertas.gubee.repository.PedidoRepository;
import com.livro.ofertas.gubee.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository repository;

    @Autowired
    PedidoProdutoRepository pprepository;

    public String salvarPedido(PedidoCompleto completo) {

        Pedido pedido = Pedido.builder().id(completo.getId()).idCliente(completo.getIdCliente()).build();
        repository.save(pedido);

        completo.getPedidoProduto().forEach(pd -> {

            PedidoProduto pedidoProduto = PedidoProduto.builder()
                    .idPedido(pd.getIdPedido())
                    .idProduto(pd.getIdProduto())
                    .quantidade(pd.getQuantidade())
                    .valor(pd.getValor()).build();

            pprepository.save(pedidoProduto);
        });

        Float valorPedido = LivroOfertaUtils.gerarValorPedido(completo.getPedidoProduto());

        return pedido.getId() + " " + valorPedido;
    }

    public PedidoCompleto buscarPedido(Integer id){

        Pedido pedido = repository.getReferenceById(id);

        List<PedidoProduto> lista = pprepository.findByIdPedido(id);

        return PedidoCompleto.builder()
                .id(pedido.getId())
                .idCliente(pedido.getIdCliente())
                .pedidoProduto(lista).build();
    }
}
