package io.github.erichika.localizacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    @Id
    @Column
    private Long id;
    @Column(length = 50)
    private String nome;
    @Column
    private Long habitantes;
}
