package io.github.erichika.localizacao.service;

import io.github.erichika.localizacao.domain.entity.Cidade;
import io.github.erichika.localizacao.domain.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static io.github.erichika.localizacao.domain.repository.specs.CidadeSpecs.*;

@Service
@RequiredArgsConstructor
public class CidadeService {
    private final CidadeRepository repository;

    public void listarCidadesPorNome() {
        System.out.println("-------------------------------------------------");
        repository.findByNome("Porto Velho").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByHabitantes(306296L).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByNomeStartingWith("Porto").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByNomeEndingWith("a").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByNomeContaining("a").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByNomeLike("%a%").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByNomeLikeIgnoreCase("SÃO%").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    public void listarCidadesPorQuantidadeHabitantes() {
        System.out.println("-------------------------------------------------");
        repository.findByHabitantesLessThan(1000000L).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByHabitantesGreaterThan(100000000L).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        repository.findByHabitantesLessThanAndNomeLike(1000000L, "P%").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    public void listarCidadesPorNomeOrdenado() {
        Pageable pageable = PageRequest.of(1, 3);

        System.out.println("-ORDENADO----------------------------------------");
        repository.findByNomeLike("%a%", Sort.by("habitantes")).forEach(System.out::println);
        System.out.println("-PAGINADO----------------------------------------");
        repository.findByNomeLike("%a%", pageable).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    public void filtroDinamco(Cidade cidade) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase("nome0")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING);
        Example<Cidade> example = Example.of(cidade, matcher);
        repository.findAll(example).forEach(System.out::println);
    }

    public void listarCidadesByNomeSpec() {
        /*
        Specification<Cidade> spec = CidadeSpecs.nomeEqual("São Paulo").and(CidadeSpecs.habitantesGreaterThan(1000));
        repository.findAll(spec).forEach(System.out::println);
        */
        repository.findAll(nomeEqual("São Paulo").and(habitantesGreaterThan(1000000L))).forEach(System.out::println);
    }

    public void listarCidadesSpecsFiltroDinamico(Cidade filtro) {
        Specification<Cidade> specs = Specification.where((root, query, cb) -> cb.conjunction());

        if (filtro.getId() != null) {
            specs = specs.and(idEqual(filtro.getId()));
        }

        if (StringUtils.hasText(filtro.getNome())) {
            specs = specs.and(nomeLikeIgnoreCase(filtro.getNome()));
        }

        if (filtro.getHabitantes() != null) {
            specs = specs.and(habitantesGreaterThan(filtro.getHabitantes()));
        }

        repository.findAll(specs).forEach(System.out::println);
    }

    public void listarCidadesPorNomeSql() {
        System.out.println("-------------------------------------------------");
        repository.findByNomeSqlNativo("São Paulo").stream()
                .map(
                        cidadeProjection -> new Cidade(
                                cidadeProjection.getId(),
                                cidadeProjection.getNome(),
                                null
                        )
                )
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }
}
