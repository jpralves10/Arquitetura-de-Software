package com.livro.ofertas.gubee.resource;

import com.livro.ofertas.gubee.model.Produto;
import com.livro.ofertas.gubee.service.Impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoServiceImpl service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarProdutoPorId(id));
    }

    @PostMapping
    public ResponseEntity<String> setProduto(@RequestBody Produto produto){
        return ResponseEntity.ok(service.salvarProduto(produto));
    }
}
