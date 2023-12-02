package org.acme.dto;

import org.acme.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public record VendaResponseDTO(
    Long id, Double valorTtotal, Long idPagamento
) {
    public VendaResponseDTO(Venda v){
        this(v.getId(), v.getValorTotal(), v.getPagamento().getId());
    }
    
}
