package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.AvaliacaoDTO;
import org.acme.dto.AvaliacaoResponseDTO;
import org.acme.model.Avaliacao;
import org.acme.repository.AvaliacaoRepository;
import org.acme.service.AvaliacaoService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Inject
    AvaliacaoRepository repository;

    @Override
    public List<AvaliacaoResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(AvaliacaoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AvaliacaoResponseDTO getId(long id) {
        return new AvaliacaoResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(AvaliacaoDTO dto) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(dto.nota());
        avaliacao.setComentario(dto.comentario());
        repository.persist(avaliacao);
        return Response.ok(new AvaliacaoResponseDTO(avaliacao)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        Avaliacao avaliacao = repository.findById(id);
        if (avaliacao != null) {
            repository.delete(avaliacao);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
