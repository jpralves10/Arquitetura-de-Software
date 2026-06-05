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
public class Produto {

    @Id
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private Float preco;
}
