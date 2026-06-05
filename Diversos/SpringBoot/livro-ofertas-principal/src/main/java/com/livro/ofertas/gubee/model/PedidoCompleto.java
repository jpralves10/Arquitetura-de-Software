package com.livro.ofertas.gubee.model;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class PedidoCompleto {

    @Id
    private Integer id;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @ElementCollection
    @Column(name = "pedidoProdutoList")
    private List<PedidoProduto> pedidoProduto = new ArrayList<>();
}
