package org.acme.service;

import jakarta.ws.rs.core.Response;
import org.acme.dto.TelefoneDTO;
import org.acme.dto.TelefoneResponseDTO;
import java.util.List;

public interface TelefoneService {

    List<TelefoneResponseDTO> getAll();

    TelefoneResponseDTO getId(long id);

    List<TelefoneResponseDTO> getCodigoArea(String codigoArea);

    TelefoneResponseDTO insert(TelefoneDTO telefoneDTO, Long idUsuario);


    Response update(Long id, TelefoneDTO telefoneDTO);

    Response delete(Long id);
}
