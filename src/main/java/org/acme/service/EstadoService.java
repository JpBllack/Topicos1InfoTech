package org.acme.service;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;

import java.util.List;

public interface EstadoService {

    public EstadoResponseDTO insert(EstadoDTO dto);

    public EstadoResponseDTO update(EstadoDTO dto, Long id);

    public void delete(Long id);

    public EstadoResponseDTO findById(Long id);

    public List<EstadoResponseDTO> findByNome(String nome);

    public List<EstadoResponseDTO> findAll(); 
}
