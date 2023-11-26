package org.acme.dto;

public record EnderecoDTO(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        Long idCidade,
        String cep
) {
}
