package org.acme.dto;

import org.acme.model.ItemVenda;

public record ItemVendaResponseDTO(
        Long id,
        Integer quantidade,
        Double valorUnitario,
        Double valorTotal,
        ProdutoResponseDTO produtoResponseDTO
) {
    public ItemVendaResponseDTO(ItemVenda i){
        this(i.getId(), i.getQuantidade(), i.getValorUnitario(), i.getValorTotal(), new ProdutoResponseDTO(i.getProduto()));
    }
}
