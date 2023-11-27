package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.VendaDTO;
import org.acme.dto.VendaResponseDTO;
import org.acme.model.Venda;
import org.acme.repository.ItemVendaRepository;
import org.acme.repository.VendaRepository;
import org.acme.service.VendaService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VendaServiceImpl implements VendaService {

    @Inject
    VendaRepository repository;

    @Inject
    ItemVendaRepository itemVendaRepository;

    @Override
    public List<VendaResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(VendaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public VendaResponseDTO getId(long id) {
        return new VendaResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(VendaDTO dto) {
        Venda venda = new Venda();
        venda.setDesconto(dto.desconto());
        dto.itemVendaList().stream()
                .map(i -> venda.getItemVendaList().add(itemVendaRepository.findById(i)));
        repository.persist(venda);
        return Response.ok(new VendaResponseDTO(venda)).build();
    }


    @Transactional
    @Override
    public Response delete(long id) {
        Venda venda = repository.findById(id);
        if (venda != null) {
            repository.delete(venda);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
