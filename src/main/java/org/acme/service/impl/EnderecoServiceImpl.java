package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.EnderecoDTO;
import org.acme.dto.EnderecoResponseDTO;
import org.acme.model.Endereco;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EnderecoRepository;
import org.acme.service.EnderecoService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    EnderecoRepository repository;

    @Inject
    CidadeRepository cidadeRepository;

    @Override
    public List<EnderecoResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(EnderecoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoResponseDTO getId(long id) {
        return new EnderecoResponseDTO(repository.findById(id));
    }

    @Transactional
    @Override
    public Response insert(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(cidadeRepository.findById(dto.idCidade()));
        endereco.setCep(dto.cep());
        repository.persist(endereco);
        return Response.ok(new EnderecoResponseDTO(endereco)).build();
    }

    @Transactional
    @Override
    public Response delete(long id) {
        Endereco endereco = repository.findById(id);
        if (endereco != null) {
            repository.delete(endereco);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
