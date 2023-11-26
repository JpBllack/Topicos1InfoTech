package org.acme.service;

import jakarta.ws.rs.core.Response;
import org.acme.dto.AvaliacaoDTO;
import org.acme.dto.AvaliacaoResponseDTO;

import java.util.List;

public interface AvaliacaoService {

    List<AvaliacaoResponseDTO> getAll();

    AvaliacaoResponseDTO getId(long id);

    Response insert(AvaliacaoDTO avaliacaoDTO);

    Response delete(long id);
}
