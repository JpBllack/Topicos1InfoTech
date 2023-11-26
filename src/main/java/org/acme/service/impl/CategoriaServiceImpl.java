package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CategoriaDTO;
import org.acme.dto.CategoriaResponseDTO;
import org.acme.model.Categoria;
import org.acme.repository.CategoriaRepository;
import org.acme.service.CategoriaService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CategoriaServiceImpl implements CategoriaService {

    @Inject
    CategoriaRepository repository;

    @Override
    public List<CategoriaResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(CategoriaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResponseDTO getId(long id) {
        return new CategoriaResponseDTO(repository.findById(id));
    }

    @Override
    public List<CategoriaResponseDTO> getNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(CategoriaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Response insert(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.nome());
        repository.persist(categoria);
        return Response.ok(new CategoriaResponseDTO(categoria)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        Categoria categoria = repository.findById(id);
        if (categoria != null) {
            repository.delete(categoria);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
