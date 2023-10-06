package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.CategoriaDTO;
import br.unitins.topicos1.dto.CategoriaResponseDTO;
import br.unitins.topicos1.model.Categoria;
import br.unitins.topicos1.repository.CategoriaRepository;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    @Transactional
    public CategoriaResponseDTO insert(CategoriaDTO dto) {
        Categoria novaCategoria = new Categoria();
        novaCategoria.setNome(dto.nome());

        categoriaRepository.persist(novaCategoria);

        return CategoriaResponseDTO.valueOf(novaCategoria);
    }

    public CategoriaResponseDTO findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria == null) {
            return null; // Ou lançar uma exceção NotFoundException
        }
        return CategoriaResponseDTO.valueOf(categoria);
    }



    @Transactional
    public CategoriaResponseDTO update(Long id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria == null) {
            return null; // Ou lançar uma exceção NotFoundException
        }
        categoria.setNome(dto.nome());

        return CategoriaResponseDTO.valueOf(categoria);
    }

    @Transactional
    public boolean delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id);
        if (categoria == null) {
            return false; // Ou lançar uma exceção NotFoundException
        }
        categoriaRepository.delete(categoria);
        return true;
    }
}
