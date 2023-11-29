package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.model.*;
import org.acme.repository.*;
import org.acme.service.VendaService;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VendaServiceImpl implements VendaService {

    public static final Logger LOG = Logger.getLogger(VendaServiceImpl.class);

    @Inject
    VendaRepository repository;

    @Inject
    ItemVendaRepository itemVendaRepository;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    PagamentoRepository pagamentoRepository;

    @Inject
    AvaliacaoRepository avaliacaoRepository;

    @Override
    public List<VendaResponseDTO> getAll() {
        try {
            LOG.info("Requisição getAll()");
            return repository.findAll().stream()
                    .map(VendaResponseDTO::new)
                    .collect(Collectors.toList());

        }catch (Exception e){
            LOG.error("Erro ao rodar Requisição getAll()");
            return null;
        }
    }

    @Override
    public VendaResponseDTO getId(long id) {
        try {
            LOG.info("Requisição getId()");
            return new VendaResponseDTO(repository.findById(id));

        }catch (Exception e){

            LOG.info("erro ao rodar Requisição getId()");
            return null;
        }
    }

    @Transactional
    @Override
    public Response insert(VendaDTO dto) {

        try {
            LOG.info("Requisição insert()");

            Venda venda = new Venda();
            venda.setDesconto(dto.desconto());
            dto.itemVendaList().stream()
                    .map(i -> venda.getItemVendaList().add(itemVendaRepository.findById(i)));
            venda.setEndereco(enderecoRepository.findById(dto.idEndereco()));
            venda.getItemVendaList().stream().forEach(i -> venda.setValorTotal(venda.getValorTotal() + i.getValorTotal()));
            repository.persist(venda);

            return Response.ok(new VendaResponseDTO(venda)).build();

        }catch (Exception e){

            LOG.info("erro ao rodar Requisição insert()");
            return Response.noContent().build();
        }
    }

    @Override
    @Transactional
    public Response insertPagamento(VendaPagamentoDTO vendaPagamentoDTO) {
        Venda v = repository.findById(vendaPagamentoDTO.idVenda());
        Pagamento p = pagamentoRepository.findById(vendaPagamentoDTO.idPagamento());
        v.setPagamento(p);
        return Response.ok(new VendaResponseDTO(v)).build();
    }

    @Override
    @Transactional
    public Response insertItemVenda(VendaItemVendaDTO vendaDTO) {
        Venda v = repository.findById(vendaDTO.idVenda());

        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setQuantidade(vendaDTO.dto().quantidade());
        itemVenda.setValorUnitario(vendaDTO.dto().valorUnitario());
        itemVenda.setProduto(produtoRepository.findById(vendaDTO.dto().idProduto()));
        itemVenda.setValorTotal(vendaDTO.dto().valorUnitario() * vendaDTO.dto().quantidade());
        itemVendaRepository.persist(itemVenda);
        v.setValorTotal(v.getValorTotal() + itemVenda.getValorTotal());
        v.getItemVendaList().add(itemVenda);
        return Response.ok(new ItemVendaResponseDTO(itemVenda)).build();
    }

    @Override
    @Transactional
    public Response insertItemVendaId(VendaItemVendaId vendaItemVendaId) {
        Venda v = repository.findById(vendaItemVendaId.idVenda());

        ItemVenda itemVenda = itemVendaRepository.findById(vendaItemVendaId.idItemVendaDTO());
        v.getItemVendaList().add(itemVenda);
        return Response.ok(new ItemVendaResponseDTO(itemVenda)).build();
    }

    @Override
    @Transactional
    public Response removeItemVendaId(VendaItemVendaId dto) {
        Venda v = repository.findById(dto.idVenda());

        ItemVenda itemVenda = itemVendaRepository.findById(dto.idItemVendaDTO());
        v.getItemVendaList().remove(itemVenda);
        v.setValorTotal(v.getValorTotal() - itemVenda.getValorTotal());
        return Response.ok(new ItemVendaResponseDTO(itemVenda)).build();
    }

    @Override
    public Response adicionaAvaliacao(AvaliacaoProdutoVendaDTO dto) {
        try {
            Venda v = repository.findById(dto.idVenda());

            Produto p = produtoRepository.findById(dto.idProduto());

            if(v.getItemVendaList().contains(p)){
                throw new Exception("Produto nao encotrado");
            }
            Avaliacao a = new Avaliacao();
            a.setComentario(dto.dto().comentario());
            a.setNota(dto.dto().nota());
            avaliacaoRepository.persist(a);
            p.getAvaliacaoList().add(a);
            return Response.ok(new AvaliacaoResponseDTO(a)).build();

        }catch (Exception e){
            return Response.noContent().build();
        }
    }

    @Override
    public Response adicionaAvaliacaoId(AvaliacaoProdutoVendaIdDTO dto) {
        try {
            Venda v = repository.findById(dto.idVenda());

            Produto p = produtoRepository.findById(dto.idProduto());

            if(v.getItemVendaList().contains(p)){
                throw new Exception("Produto nao encotrado");
            }
            Avaliacao a = avaliacaoRepository.findById(dto.avaliacaoId());
            p.getAvaliacaoList().add(a);
            return Response.ok().build();
        }catch (Exception e){
            return Response.noContent().build();
        }
    }


    @Transactional
    @Override
    public Response delete(long id) {
        try {
            LOG.info("Requisição delete()");
            Venda venda = repository.findById(id);
            if (venda != null) {
                repository.delete(venda);
                return Response.ok().build();
        } else {
            throw new Exception("venda não encontrado!");
        }
        }catch (Exception e){

            LOG.info("erro ao rodar Requisição delete() - " + e.getMessage());
            return Response.notModified(e.getMessage()).build();
        }

    }
}
