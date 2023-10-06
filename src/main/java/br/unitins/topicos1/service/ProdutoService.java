package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Produto;

public interface ProdutoService {

    public ProdutoResponseDTO insert(ProdutoDTO dto);

    public ProdutoResponseDTO update(ProdutoDTO dto, Long id);

    public void delete(Long id);

    public List<ProdutoResponseDTO> findByAll();

    public ProdutoResponseDTO findById(Long id);

    public List<Produto> findByCategoria(Long categoriaId);
}
