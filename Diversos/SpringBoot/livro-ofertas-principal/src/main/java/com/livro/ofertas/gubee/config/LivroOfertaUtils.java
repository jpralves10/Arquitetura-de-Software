package com.livro.ofertas.gubee.config;

import com.livro.ofertas.gubee.model.PedidoProduto;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LivroOfertaUtils {

    public static Float gerarValorPedido(List<PedidoProduto> list){

        AtomicReference<Float> valorTotal = new AtomicReference<>(0.0f);

        list.forEach(pd -> {

            PedidoProduto pedidoProduto = PedidoProduto.builder()
                    .idPedido(pd.getIdPedido())
                    .idProduto(pd.getIdProduto())
                    .quantidade(pd.getQuantidade())
                    .valor(pd.getValor()).build();

            valorTotal.set(valorTotal.get() + pedidoProduto.getValor());
        });

        return valorTotal.get();
    }
}
