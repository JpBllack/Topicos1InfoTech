package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.TelefoneDTO;
import org.acme.dto.TelefoneResponseDTO;
import org.acme.model.Telefone;
import org.acme.repository.TelefoneRepository;
import org.acme.service.TelefoneService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TelefoneServiceImpl implements TelefoneService {
    @Inject
    TelefoneRepository repository;

    @Override
    public List<TelefoneResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(TelefoneResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public TelefoneResponseDTO getId(long id) {
        return new TelefoneResponseDTO(repository.findById(id));
    }

    @Override
    public List<TelefoneResponseDTO> getCodigoArea(String codigoArea) {
        return repository.findByCodigoArea(codigoArea).stream()
                .map(TelefoneResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Response insert(TelefoneDTO dto) {
        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.codigoArea());
        telefone.setNumero(dto.numero());
        repository.persist(telefone);
        return Response.ok(new TelefoneResponseDTO(telefone)).build();
    }

    @Transactional
    @Override
    public Response update(Long id, TelefoneDTO dto) {
        Telefone telefone = repository.findById(id);
        if (telefone != null) {
            telefone.setCodigoArea(dto.codigoArea());
            telefone.setNumero(dto.numero());
            repository.persist(telefone);
            return Response.ok(new TelefoneResponseDTO(telefone)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Transactional
    @Override
    public Response delete(Long id) {
        Telefone telefone = repository.findById(id);
        if (telefone != null) {
            repository.delete(telefone);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
