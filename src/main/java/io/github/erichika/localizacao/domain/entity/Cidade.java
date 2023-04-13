package io.github.erichika.localizacao.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
public class Cidade {
    @Id
    @Column
    private Long id;
    @Column(length = 50)
    private String nome;
    @Column
    private Long habitantes;
}
