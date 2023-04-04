package io.github.erichika.service;

import io.github.erichika.domain.entity.Pedido;
import io.github.erichika.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto);
}
