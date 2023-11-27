package org.acme.dto;

public record CartaoCreditoDTO(
        String numeroCartao, String dataValidade, String cvv, String bandeiraCartao, Double valor
) {
}
