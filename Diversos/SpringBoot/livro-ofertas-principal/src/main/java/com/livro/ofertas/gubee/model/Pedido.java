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
public class Pedido {

    @Id
    private Integer id;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "processado")
    private Boolean processado;
}
