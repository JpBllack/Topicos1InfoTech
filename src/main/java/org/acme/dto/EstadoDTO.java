package org.acme.dto;

import org.acme.model.Estado;

public record EstadoDTO(
    String nome,
    String sigla
) {
}
