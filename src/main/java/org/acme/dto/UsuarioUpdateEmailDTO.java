package org.acme.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioUpdateEmailDTO(
        @NotBlank
                @Email
        String email
) {
}
