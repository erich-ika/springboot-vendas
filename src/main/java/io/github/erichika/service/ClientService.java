package io.github.erichika.service;

import io.github.erichika.model.Cliente;
import io.github.erichika.repository.ClientesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public ClientesRepository repository;

    public ClientService(ClientesRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente) {
        //aplica validações
    }
}
