package com.livro.ofertas.gubee.repository;

import com.livro.ofertas.gubee.model.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Integer> {

    @Query("SELECT u FROM PedidoProduto u WHERE u.idPedido = :idPedido")
    List<PedidoProduto> findByIdPedido(@Param("idPedido") int idPedido);

    //List<PedidoProduto> findByIdPedido(Integer idPedido);

    //List<PedidoProduto> findByIdProduto(Integer idProduto);
}
