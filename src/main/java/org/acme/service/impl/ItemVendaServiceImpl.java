package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ItemVendaDTO;
import org.acme.dto.ItemVendaResponseDTO;
import org.acme.model.ItemVenda;
import org.acme.repository.ItemVendaRepository;
import org.acme.repository.ProdutoRepository;
import org.acme.service.ItemVendaService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ItemVendaServiceImpl implements ItemVendaService {

    @Inject
    ItemVendaRepository repository;

    @Inject
    ProdutoRepository produtoRepository;

    @Override
    public List<ItemVendaResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(ItemVendaResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ItemVendaResponseDTO getId(long id) {
        return new ItemVendaResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(ItemVendaDTO dto) {
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setQuantidade(dto.quantidade());
        itemVenda.setValorUnitario(dto.valorUnitario());
        itemVenda.setProduto(produtoRepository.findById(dto.idProduto()));
        itemVenda.setValorTotal(dto.valorUnitario() * dto.quantidade());
        repository.persist(itemVenda);
        return Response.ok(new ItemVendaResponseDTO(itemVenda)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        ItemVenda itemVenda = repository.findById(id);
        if (itemVenda != null) {
            repository.delete(itemVenda);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
