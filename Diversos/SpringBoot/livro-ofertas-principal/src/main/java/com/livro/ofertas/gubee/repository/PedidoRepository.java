package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT u FROM Pedido u WHERE u.processado = :processado")
    List<Pedido> findByProcessado(@Param("processado") boolean processado);
}
