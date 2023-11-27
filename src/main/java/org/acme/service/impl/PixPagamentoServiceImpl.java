package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PixPagamentoDTO;
import org.acme.dto.PixPagamentoResponseDTO;
import org.acme.model.PixPagamento;
import org.acme.repository.PixPagamentoRepository;
import org.acme.service.PixPagamentoService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PixPagamentoServiceImpl implements PixPagamentoService {
    @Inject
    PixPagamentoRepository repository;

    @Override
    public List<PixPagamentoResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(PixPagamentoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PixPagamentoResponseDTO getId(long id) {
        return new PixPagamentoResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(PixPagamentoDTO dto) {
        PixPagamento pixPagamento = new PixPagamento();
        pixPagamento.setChave(dto.chave());
        pixPagamento.setValor(dto.valor());
        repository.persist(pixPagamento);
        return Response.ok(new PixPagamentoResponseDTO(pixPagamento)).build();
    }

    @Transactional
    @Override
    public Response update(Long id, PixPagamentoDTO dto) {
        PixPagamento pixPagamento = repository.findById(id);
        if (pixPagamento != null) {
            pixPagamento.setChave(dto.chave());
            pixPagamento.setValor(dto.valor());
            repository.persist(pixPagamento);
            return Response.ok(new PixPagamentoResponseDTO(pixPagamento)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Transactional
    @Override
    public Response delete(Long id) {
        PixPagamento pixPagamento = repository.findById(id);
        if (pixPagamento != null) {
            repository.delete(pixPagamento);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
