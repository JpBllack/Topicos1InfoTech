package org.acme.dto;

import org.acme.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public record VendaResponseDTO(
    Long id, Double valorTtotal,List<ItemVendaResponseDTO> itens, PagamentoResponseDTO pagamento
) {
    public VendaResponseDTO(Venda v){
        this(v.getId(), v.getValorTotal(), v.getItemVendaList().stream().map(ItemVendaResponseDTO::new).collect(Collectors.toList()), new PagamentoResponseDTO(v.getPagamento()));
    }
    
}
