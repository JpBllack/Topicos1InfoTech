package org.acme.dto;

import org.acme.model.CartaoCredito;

public record CartaoCreditoResponseDTO(
        Long id, String numeroCartao, String dataValidade, String cvv, String bandeiraCartao
) {
    public CartaoCreditoResponseDTO(CartaoCredito c){
        this(c.getId(), c.getNumeroCartao(), c.getDataValidade(), c.getCvv(), c.getBandeiraCartao());
    }
}
