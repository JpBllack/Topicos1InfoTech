package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Categoria;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.CategoriaRepository;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository prodRepo;

    @Inject
    CategoriaRepository categoriaRepository;

    @Override
    @Transactional
    public ProdutoResponseDTO insert(ProdutoDTO dto) {
        Produto novoProduto = new Produto();
        novoProduto.setNome(dto.nome());
        novoProduto.setDescricao(dto.descricao());
        novoProduto.setPreco(dto.preco());

        // Você pode adicionar a associação com a categoria aqui
        // novoProduto.setCategoria(categoria);

        prodRepo.persist(novoProduto);

        return ProdutoResponseDTO.valueOf(novoProduto);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(ProdutoDTO dto, Long id) {
        Produto produto = prodRepo.findById(id);
        if (produto != null) {
            produto.setNome(dto.nome());
            produto.setDescricao(dto.descricao());
            produto.setPreco(dto.preco());

            // Você pode atualizar a associação com a categoria aqui
            // produto.setCategoria(categoria);

        } else {
            throw new NotFoundException();
        }

        return ProdutoResponseDTO.valueOf(produto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!prodRepo.deleteById(id)) {
            throw new NotFoundException();
        }
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        return ProdutoResponseDTO.valueOf(prodRepo.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findByAll() {
        return prodRepo.listAll().stream()
            .map(ProdutoResponseDTO::valueOf)
            .collect(Collectors.toList());
    }

    @Override
    public List<Produto> findByCategoria(Long categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId);
        
        if (categoria == null) {
            throw new NotFoundException("Categoria não encontrada");
        }
        
        // Agora você pode usar o repositório de Produto para buscar produtos por categoria.
        return prodRepo.list("categoria", categoria);
    }
    
}
