package io.github.erichika.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "data_pedido")
    private LocalDate dataPedido;
    @Column(length = 20, precision = 2)
    private BigDecimal total;
}
