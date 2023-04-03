package io.github.erichika.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "nome", length = 100)
    private String nome;
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
