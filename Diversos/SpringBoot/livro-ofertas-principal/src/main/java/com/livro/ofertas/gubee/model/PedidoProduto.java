package com.livro.ofertas.gubee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class PedidoProduto {

    @Column(name = "idPedido")
    private String idPedido;

    @Id
    @Column(name = "idProduto")
    private String idProduto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor")
    private Float valor;
}
