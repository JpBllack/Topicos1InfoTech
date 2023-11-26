package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.BoletoBancarioDTO;
import org.acme.dto.BoletoBancarioResponseDTO;
import org.acme.model.BoletoBancario;
import org.acme.repository.BoletoBancarioRepository;
import org.acme.service.BoletoBancarioService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BoletoBancarioServiceImpl implements BoletoBancarioService {

    @Inject
    BoletoBancarioRepository repository;

    @Override
    public List<BoletoBancarioResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(BoletoBancarioResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BoletoBancarioResponseDTO getId(long id) {
        return new BoletoBancarioResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(BoletoBancarioDTO dto) {
        BoletoBancario boletoBancario = new BoletoBancario();
        boletoBancario.setBanco(dto.banco());
        boletoBancario.setNumeroBoleto(dto.numeroBoleto());
        boletoBancario.setPago(true);
        repository.persist(boletoBancario);
        return Response.ok(new BoletoBancarioResponseDTO(boletoBancario)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        BoletoBancario boletoBancario = repository.findById(id);
        if (boletoBancario != null) {
            repository.delete(boletoBancario);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
