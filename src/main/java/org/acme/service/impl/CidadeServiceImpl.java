package org.acme.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.dto.CidadeDTO;
import org.acme.dto.CidadeResponseDTO;
import org.acme.model.Cidade;
import org.acme.repository.CidadeRepository;
import org.acme.repository.EstadoRepository;
import org.acme.service.CidadeService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService{

    @Inject
    CidadeRepository repository;

    @Inject
    EstadoRepository estadoRepository;

    @Override
    @Transactional
    public Response insert(CidadeDTO dtoCidade) {
        try {
            Cidade novaCidade = new Cidade();
            novaCidade.setNome(dtoCidade.nome());
            novaCidade.setEstado(estadoRepository.findById(dtoCidade.idEstado()));
            if(novaCidade.getEstado() == null){ //EXEMPLO DE CRIAÇÃO DE EXCEÇÃO (SEM NOTAÇÃO NO ATRIBUTO - MODEL)
                throw new Exception("Estado não pode ser nulo");
            }
            repository.persist(novaCidade);
        
            return Response.ok(new CidadeResponseDTO(novaCidade)).build();
        } catch (Exception e) {
            return Response.notModified(e.toString()).build();
        }
        
    }

    @Override
    @Transactional
    public CidadeResponseDTO update(CidadeDTO cidadeDTO, Long id) {
        
        Cidade cidade = repository.findById(id);
        cidade.setNome(cidadeDTO.nome());
        cidade.setEstado(estadoRepository.findById(cidadeDTO.idEstado()));
        
        return new CidadeResponseDTO (cidade);
    }

    @Override
    @Transactional //Anuncia mudança no banco de dados
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException("Error");
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        return new CidadeResponseDTO(repository.findById(id));

       }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) { //Retorno de dados usa o ResponseDTO, DTO inserção de dados.
        return repository.findByNome(nome).stream().map(cidade -> new CidadeResponseDTO(cidade)).collect(Collectors.toList());
        //stream gera a copia da lista, map permite o uso da lambda que transforma cidade em cidadeResponse e o collect transforma o objeto em lista.
    }

    @Override
    public List<CidadeResponseDTO> findAll() {
        return repository.findAll().stream().map(cidade -> new CidadeResponseDTO(cidade)).collect(Collectors.toList());
    }
    
}
