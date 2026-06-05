package com.livro.ofertas.gubee.service;

import com.livro.ofertas.gubee.model.Cliente;

public interface ClienteService {

    String salvarCliente(Cliente cliente);

    Cliente buscarClientePorId(Integer id);
}
