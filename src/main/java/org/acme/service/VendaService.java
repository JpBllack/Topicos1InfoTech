package org.acme.service;

import jakarta.ws.rs.core.Response;
import org.acme.dto.VendaDTO;
import org.acme.dto.VendaResponseDTO;

import java.util.List;

public interface VendaService {

    List<VendaResponseDTO> getAll();

    VendaResponseDTO getId(long id);

    Response insert(VendaDTO vendaDTO);

    Response delete(long id);
}
