package io.github.erichika.rest.dto;

import io.github.erichika.validation.NotEmpyList;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    @NotNull(message = "Informe o código do cliente.")
    private Integer cliente;
    @NotNull(message = "Total do pedido é obrigatório.")
    private BigDecimal total;
    @NotEmpyList(message = "Itens do pedido são obrigatórios.")
    private List<ItemPedidoDTO> itens;
}
