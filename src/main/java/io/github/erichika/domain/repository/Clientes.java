package io.github.erichika.domain.repository;

import io.github.erichika.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select c from Cliente c where c.nome like %:nome%")
    List<Cliente> findByNomeLike( @Param("nome") String nome);

    @Query("delete from Cliente  c where c.nome = :nome")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String erich);
}
