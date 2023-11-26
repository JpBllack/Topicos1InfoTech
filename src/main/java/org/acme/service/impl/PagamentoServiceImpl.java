package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.PagamentoDTO;
import org.acme.dto.PagamentoResponseDTO;
import org.acme.model.Pagamento;
import org.acme.repository.PagamentoRepository;
import org.acme.service.PagamentoService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PagamentoServiceImpl implements PagamentoService {

    @Inject
    PagamentoRepository repository;

    @Override
    public List<PagamentoResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(PagamentoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public PagamentoResponseDTO getId(long id) {
        return new PagamentoResponseDTO(repository.findById(id));
    }

    @Override
    public List<PagamentoResponseDTO> getByTipo(String tipo) {
        return repository.findByTipo(tipo).stream()
                .map(PagamentoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Response insert(PagamentoDTO dto) {
        Pagamento pagamento = new Pagamento();
        pagamento.setTipo(dto.tipo());
        pagamento.setValor(dto.valor());
        pagamento.setPago(true);
        repository.persist(pagamento);
        return Response.ok(new PagamentoResponseDTO(pagamento)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        Pagamento pagamento = repository.findById(id);
        if (pagamento != null) {
            repository.delete(pagamento);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
