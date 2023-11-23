package br.unitins.topicos1.service;
import java.util.List;

import br.unitins.topicos1.dto.CidadeDTO;
import br.unitins.topicos1.dto.CidadeResponseDTO;
import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.repository.CidadeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    @Inject
    CidadeRepository repository;

    @Override
    @Transactional
    public CidadeResponseDTO insert(CidadeDTO dto) {
        Cidade novoCidade = new Cidade();
        novoCidade.setNome(dto.getNome());

        repository.persist(novoCidade);

        return CidadeResponseDTO.valueOf(novoCidade);
    }

    @Override
    @Transactional
    public CidadeResponseDTO update(CidadeDTO dto, Long id) {
        
        Cidade cidade = repository.findById(id);
        if (cidade != null) {
            cidade.setNome(dto.getNome());
        
        } else 
            throw new NotFoundException();

        return CidadeResponseDTO.valueOf(cidade);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        return CidadeResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CidadeResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }
    
}
