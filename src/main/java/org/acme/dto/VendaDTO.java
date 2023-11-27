package org.acme.dto;

import java.util.List;

public record VendaDTO(
    Double desconto,
    List<Long> itemVendaList,
    Long idEndereco
) {
    
}
