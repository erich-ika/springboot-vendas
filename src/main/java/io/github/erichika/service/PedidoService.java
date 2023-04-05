package io.github.erichika.service;

import io.github.erichika.domain.entity.Pedido;
import io.github.erichika.domain.entity.enums.StatusPedido;
import io.github.erichika.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
