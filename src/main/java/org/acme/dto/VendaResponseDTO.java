package org.acme.dto;

import org.acme.model.Venda;

import java.util.List;
import java.util.stream.Collectors;

public record VendaResponseDTO(
    Long id, Double valorTtotal, Double desconto, List<ItemVendaResponseDTO> itens, PagamentoResponseDTO pagamento
) {
    public VendaResponseDTO(Venda v){
        this(v.getId(), v.getValorTotal(), v.getDesconto(), v.getItemVendaList().stream().map(ItemVendaResponseDTO::new).collect(Collectors.toList()), new PagamentoResponseDTO(v.getPagamento()));
    }
    
}
