package io.github.erichika;

import io.github.erichika.domain.entity.Cliente;
import io.github.erichika.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Erich"));
            clientes.save(new Cliente("Outro Cliente"));

            boolean existe = clientes.existsByNome("Fulano");
            System.out.println("Existe nome Fulano? " + existe);

            System.out.println("Buscando clientes");
            clientes.findByNomeLike("Cli").forEach(System.out::println);

/*
            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Atyalizando clientes");
            todosClientes.forEach(cliente -> {
                cliente.setNome(cliente.getNome() + " atualizado");
                clientes.save(cliente);
            });

            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.findByNomeLike("Cli").forEach(System.out::println);

            System.out.println("Deletando clientes");
            clientes.findAll().forEach(cliente -> {
                clientes.delete(cliente);
            });

            todosClientes = clientes.findAll();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado");
            } else {
                todosClientes.forEach((System.out::println));
            }*/
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
