package org.acme.dto;

import org.acme.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public record VendaResponseDTO(
    Long id, Double valorTtotal, PagamentoResponseDTO pagamento
) {
    public VendaResponseDTO(Venda v){
        this(v.getId(), v.getValorTotal(), new PagamentoResponseDTO(v.getPagamento()));
    }
    
}
