package io.github.erichika.localizacao.domain.repository;

import io.github.erichika.localizacao.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByNome(String nome);
    List<Cidade> findByNomeLike(String nome);
    @Query("select c from Cidade c where upper(c.nome) like upper(?1)")
    List<Cidade> findByNomeLikeIgnoreCase(String nome);
    List<Cidade> findByNomeStartingWith(String nome);
    List<Cidade> findByNomeEndingWith(String nome);
    List<Cidade> findByNomeContaining(String nome);
    List<Cidade> findByHabitantes(Long habitantes);
    List<Cidade> findByHabitantesLessThan(Long habitantes);
    List<Cidade> findByHabitantesGreaterThan(Long habitantes);
    List<Cidade> findByHabitantesLessThanAndNomeLike(Long habitantes, String nome);
}
