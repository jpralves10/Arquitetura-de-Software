package com.livro.ofertas.gubee.resource;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/cliente")
public class ClienteResource {

    @Autowired
    private ClienteServiceImpl service;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Integer id){
        return ResponseEntity.ok(service.buscarClientePorId(id));
    }

    @PostMapping
    public ResponseEntity<String> setCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(service.salvarCliente(cliente));
    }
}
