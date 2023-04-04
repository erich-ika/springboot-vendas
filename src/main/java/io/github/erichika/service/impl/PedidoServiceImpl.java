package io.github.erichika.service.impl;

import io.github.erichika.domain.repository.Pedidos;
import io.github.erichika.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }
}
