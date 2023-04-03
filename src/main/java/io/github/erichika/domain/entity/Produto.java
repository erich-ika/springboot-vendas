package io.github.erichika.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column
    private String descricao;
    @Column(name = "preco_unitario")
    private BigDecimal preco;
}
