package com.livro.ofertas.gubee.service.Impl;

import com.livro.ofertas.gubee.model.Produto;
import com.livro.ofertas.gubee.repository.ProdutoRepository;
import com.livro.ofertas.gubee.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public Produto buscarProdutoPorId(Integer id){
        return repository.getReferenceById(id);
    }

    @Transactional
    public String salvarProduto(Produto produto) {
        Produto pro = repository.save(produto);
        return pro.getId() + " " + pro.getNome() + " " + pro.getPreco();
    }
}
