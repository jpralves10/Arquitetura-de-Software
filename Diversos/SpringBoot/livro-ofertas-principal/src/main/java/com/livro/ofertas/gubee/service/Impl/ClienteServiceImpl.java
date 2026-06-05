package com.livro.ofertas.gubee.service.Impl;

import com.livro.ofertas.gubee.model.Cliente;
import com.livro.ofertas.gubee.repository.ClienteRepository;
import com.livro.ofertas.gubee.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository repository;

    public Cliente buscarClientePorId(Integer id){
        return repository.getReferenceById(id);
    }

    @Transactional
    public String salvarCliente(Cliente cliente) {
        Cliente cli = repository.save(cliente);
        return cli.getId() + " " + cli.getNome();
    }
}
