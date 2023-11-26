package org.acme.dto;

import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioUpdateCpfDTO(
        @CPF String cpf
) {
}
