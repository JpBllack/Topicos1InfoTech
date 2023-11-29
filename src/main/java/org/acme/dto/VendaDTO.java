package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record VendaDTO(
    List<Long> itemVendaList,
    @NotBlank(message = "O campo 'idEndereco' não pode ser vazio!") Long idEndereco
) {
    
}
