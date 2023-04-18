package io.github.erichika.localizacao;

import io.github.erichika.localizacao.domain.entity.Cidade;
import io.github.erichika.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    @Override
    public void run(String... args) {
        service.filtroDinamco(new Cidade(null, "PORTO", null));
        // service.listarCidadesPorNomeOrdenado();
        // service.listarCidadesPorNome();
        // service.listarCidadesPorQuantidadeHabitantes();
    }

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }
}
