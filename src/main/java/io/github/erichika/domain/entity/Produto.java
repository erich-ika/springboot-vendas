package io.github.erichika.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column
    @NotEmpty(message = "Descrição é obrigatória.")
    private String descricao;
    @Column(name = "preco_unitario")
    @NotNull(message = "Preço é obrigatório")
    private BigDecimal preco;
}
