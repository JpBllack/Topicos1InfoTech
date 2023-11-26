package org.acme.service.impl;

import java.util.List;

import org.acme.dto.EstadoDTO;
import org.acme.dto.EstadoResponseDTO;
import org.acme.model.Estado;
import org.acme.repository.EstadoRepository;
import org.acme.service.EstadoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository repository;

    @Override
    @Transactional
    public EstadoResponseDTO insert(EstadoDTO dto) {
    
        Estado novoEstado = new Estado();
        novoEstado.setnome(dto.nome());
        novoEstado.setsigla(dto.sigla());

        repository.persist(novoEstado);
        return new EstadoResponseDTO(novoEstado);
     }

    @Override
    @Transactional
    public EstadoResponseDTO update(EstadoDTO dto, Long id) {
        
        Estado estado = repository.findById(id);
        if (estado != null) {
            estado.setnome(dto.nome());
            estado.setsigla(dto.sigla());
        } else 
            throw new NotFoundException();

        return new EstadoResponseDTO(estado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        return new EstadoResponseDTO(repository.findById(id));
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> new EstadoResponseDTO(e)).toList();
    }

    @Override
    public List<EstadoResponseDTO> findAll() {
        return repository.listAll().stream()
            .map(e -> new EstadoResponseDTO(e)).toList();
    }
}
