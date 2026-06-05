package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.PedidoCompleto;

public interface PedidoService {

    String salvarPedido(PedidoCompleto completo);

    PedidoCompleto buscarPedido(Integer id);
}
