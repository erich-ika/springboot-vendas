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
            clientes.salvar(new Cliente("Erich"));
            clientes.salvar(new Cliente("Outro Cliente"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach((System.out::println));

            System.out.println("Atyalizando clientes");
            todosClientes.forEach(cliente -> {
                cliente.setNome(cliente.getNome() + " atualizado");
                clientes.atualizar(cliente);
            });

            System.out.println("Buscando clientes");
            clientes.buscarPorNome("Cli").forEach(System.out::println);


            System.out.println("Deletando clientes");
            clientes.deletar(2);


            todosClientes = clientes.obterTodos();
            if (todosClientes.isEmpty()) {
                System.out.println("Nenhum cliente encontrado");
            } else {
                todosClientes.forEach((System.out::println));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
