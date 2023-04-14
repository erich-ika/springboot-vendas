package io.github.erichika.localizacao;

import io.github.erichika.localizacao.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) {
        listarCidadesPorNome();
        listarCidadesPorQuantidadeHabitantes();
    }

    void listarCidadesPorNome() {
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByNome("Porto Velho").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByHabitantes(306296L).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByNomeEndingWith("a").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByNomeContaining("a").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByNomeLike("%a%").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByNomeLikeIgnoreCase("SÃO%").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    void listarCidadesPorQuantidadeHabitantes() {;
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByHabitantesLessThan(1000000L).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByHabitantesGreaterThan(100000000L).forEach(System.out::println);
        System.out.println("-------------------------------------------------");
        cidadeRepository.findByHabitantesLessThanAndNomeLike(1000000L, "P%").forEach(System.out::println);
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

}
