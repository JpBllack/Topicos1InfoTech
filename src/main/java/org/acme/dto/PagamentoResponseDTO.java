package org.acme.dto;

import org.acme.model.Pagamento;

public record PagamentoResponseDTO(
        Long id,
        String tipo,
        Double valor,
        Boolean pago
) {
    public  PagamentoResponseDTO(Pagamento p){
        this(p.getId(), p.getTipo(), p.getValor(), p.getPago());
    }
}
