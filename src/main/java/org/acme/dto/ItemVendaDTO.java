package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemVendaDTO(
        @NotNull(message = "o campo 'quantidade' tem que ser preenchido!")
        @NotBlank(message = "o campo 'quantidade' tem que ser preenchido!")
        Integer quantidade,
        @NotNull(message = "o campo 'valorUnitario' tem que ser preenchido!")
        @NotBlank(message = "o campo 'valorUnitario' tem que ser preenchido!")
        Double valorUnitario,
        @NotNull(message = "o campo 'idProduto' tem que ser preenchido!")
        @NotBlank(message = "o campo 'idProduto' tem que ser preenchido!")
        Long idProduto
) {
}
