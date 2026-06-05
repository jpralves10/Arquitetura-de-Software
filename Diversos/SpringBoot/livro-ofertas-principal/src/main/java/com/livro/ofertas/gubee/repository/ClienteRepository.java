package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
