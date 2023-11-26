package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.CartaoCreditoDTO;
import org.acme.dto.CartaoCreditoResponseDTO;
import org.acme.model.CartaoCredito;
import org.acme.repository.CartaoCreditoRepository;
import org.acme.service.CartaoCreditoService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CartaoCreditoServiceImpl implements CartaoCreditoService {

    @Inject
    CartaoCreditoRepository repository;

    @Override
    public List<CartaoCreditoResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(CartaoCreditoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CartaoCreditoResponseDTO getId(long id) {
        return new CartaoCreditoResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(CartaoCreditoDTO dto) {
        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setNumeroCartao(dto.numeroCartao());
        cartaoCredito.setDataValidade(dto.dataValidade());
        cartaoCredito.setCvv(dto.cvv());
        cartaoCredito.setBandeiraCartao(dto.bandeiraCartao());
        repository.persist(cartaoCredito);
        return Response.ok(new CartaoCreditoResponseDTO(cartaoCredito)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        CartaoCredito cartaoCredito = repository.findById(id);
        if (cartaoCredito != null) {
            repository.delete(cartaoCredito);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
