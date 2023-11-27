package org.acme.service;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.acme.dto.ProdutoDTO;
import org.acme.dto.ProdutoResponseDTO;
import org.acme.form.ImageForm;
import org.acme.model.Produto;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.io.File;
import java.util.List;

public interface ProdutoService {

    public List<ProdutoResponseDTO> getAll();

    public ProdutoResponseDTO getId(@PathParam("id") long id);

    public List<ProdutoResponseDTO> getNome(@PathParam("nome") String nome);

    public Response insert(ProdutoDTO produtoDTO);

    public Response update(@PathParam("id") long id, ProdutoDTO produto);

    public Response delete(@PathParam("id") Long id);

    public Response retiraEstoque(@PathParam("id") Long id, int quantidade);

    public Response adicionaEstoque(@PathParam("id") Long id, int quantidade);

    public Response salvarImagem(@MultipartForm ImageForm form, Long produtoId);

    public Response downloadImagem(Long produtoId);
}
