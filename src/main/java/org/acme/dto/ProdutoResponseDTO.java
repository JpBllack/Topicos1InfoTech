package org.acme.dto;

import org.acme.model.Produto;

public record ProdutoResponseDTO() {
    public ProdutoResponseDTO(Produto p){
        this();
    }
}
