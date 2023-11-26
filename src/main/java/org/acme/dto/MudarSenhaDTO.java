package org.acme.dto;

public record MudarSenhaDTO(
        String login,
        String senhaAntiga,
        String novaSenha) {
}
