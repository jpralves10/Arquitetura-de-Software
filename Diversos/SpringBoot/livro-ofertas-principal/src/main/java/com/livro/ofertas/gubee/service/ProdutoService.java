package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.Produto;

public interface ProdutoService {

    Produto buscarProdutoPorId(Integer id);

    String salvarProduto(Produto produto);
}
