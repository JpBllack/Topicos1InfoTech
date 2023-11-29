package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CidadeDTO(
    @NotBlank @Size(min = 2) String nome,
    @NotBlank Long idEstado
) {
    
}
