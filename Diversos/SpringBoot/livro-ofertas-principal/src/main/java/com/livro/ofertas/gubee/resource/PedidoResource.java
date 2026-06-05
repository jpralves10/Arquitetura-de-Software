package com.livro.ofertas.gubee.resource;

import com.livro.ofertas.gubee.model.PedidoCompleto;
import com.livro.ofertas.gubee.service.Impl.PedidoServiceImpl;
import com.livro.ofertas.gubee.service.Impl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/pedido")
public class PedidoResource {

    @Autowired
    private PedidoServiceImpl service;

    @Autowired
    private RedisServiceImpl serviceRedis;

    @GetMapping(path = "/{id}")
    public ResponseEntity<PedidoCompleto> getPedido(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarPedido(id));
    }

    @PostMapping
    public ResponseEntity<String> setPedido(@RequestBody PedidoCompleto pedidoCompleto){
        return ResponseEntity.ok(service.salvarPedido(pedidoCompleto));
    }

    @GetMapping(path = "/processado/{chave}")
    public ResponseEntity<String> consultarPedidosProcessados(@PathVariable String chave){
        return ResponseEntity.ok(serviceRedis.buscarDados(chave));
    }
}

