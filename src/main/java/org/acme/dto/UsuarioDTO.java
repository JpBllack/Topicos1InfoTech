package org.acme.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record UsuarioDTO(

        @CPF
                String cpf,
                @NotBlank
                String nome,
                @Email
                String email,
                @NotBlank @Size(min = 3, max = 1000) String senha) {

}