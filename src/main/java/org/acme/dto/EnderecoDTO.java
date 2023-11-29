package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(
        String logradouro,
        String numero,
        @NotBlank String complemento,
        String bairro,
        @NotBlank Long idCidade,
        @NotBlank String cep
) {
}
