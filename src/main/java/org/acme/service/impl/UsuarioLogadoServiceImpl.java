package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.model.Endereco;
import org.acme.model.Telefone;
import org.acme.model.Usuario;
import org.acme.repository.*;
import org.acme.service.EnderecoService;
import org.acme.service.HashService;
import org.acme.service.TelefoneService;
import org.acme.service.UsuarioLogadoService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    public static final Logger LOG = Logger.getLogger(UsuarioLogadoServiceImpl.class);


    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    HashService hash;

    @Inject
    TelefoneService telefoneService;

    @Inject
    TelefoneRepository telefoneRepository;

    @Inject
    EnderecoService enderecoService;

    @Inject
    EnderecoRepository enderecoRepository;

    @Inject
    VendaRepository vendaRepository;

    @Inject
    CidadeRepository cidadeRepository;

    @Transactional
    @Override
    public Response updateSenha(UsuarioLogadoMudarSenhaDTO senha) {
        try {

            LOG.info("Requisição updateSenha()");
            Usuario entity = usuarioRepository.findById(jsonWebToken.getSubject());
            String has = hash.getHashSenha(senha.senhaAntiga());
            if(Objects.equals(has, entity.getSenha())) {
                entity.setSenha(hash.getHashSenha(senha.novaSenha()));
                return Response.ok(new UsuarioResponseDTO(entity)).build();
            }
            else {
                throw new Exception("Senha anterior Incorreta");
            }} catch (Exception e) {
            LOG.error("Requisição updateSenha()");
            return Response.notModified(e.getMessage()).build();
        }
    }

    @Transactional
    @Override
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login) {
        try {

            LOG.info("Requisição updateLogin()");
            Usuario entity = usuarioRepository.findById(jsonWebToken.getSubject());

            entity.setLogin(login.login());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            LOG.error("Requisição updateLogin()");
            return null;
        }
    }

    @Transactional
    @Override
    public Response updateNome(UsuarioUpdateNomeDTO nome) {
        try {
            LOG.info("Requisição updateNome()");

            Usuario entity = usuarioRepository.findById(jsonWebToken.getSubject());

            entity.setNome(nome.nome());
            return Response.ok().build();
        } catch (Exception e) {
            LOG.error("Requisição updateNome()");
            return Response.notModified(e.getMessage()).build();
        }
    }

    @Transactional
    @Override
    public Response updateEmail(UsuarioUpdateEmailDTO dto) {
        try {
            LOG.info("Requisição updateEmail()");

            Usuario entity = usuarioRepository.findById(jsonWebToken.getSubject());

            entity.setEmail(dto.email());
            return Response.ok().build();
        } catch (Exception e) {
            LOG.error("Requisição updateEmail()");
            return Response.notModified(e.getMessage()).build();
        }
    }
    @Transactional
    @Override
    public Response updateTelefone(TelefoneDTO dto) {
        try {
            LOG.info("Requisição updateTelefone()");

            Usuario entity = usuarioRepository.findById(jsonWebToken.getSubject());

            AtomicReference<Telefone> t = new AtomicReference<>(new Telefone());
            telefoneRepository.findAll().stream().forEach(tel -> {
                if(tel.getUsuario().getId() == entity.getId()){
                    t.set(tel);
                }
            });
            if(t.get() == null){
                Telefone telefone = new Telefone();
                telefone.setNumero(dto.numero());
                telefone.setCodigoArea(dto.codigoArea());
                telefone.setUsuario(entity);
                telefoneRepository.persist(telefone);
                return Response.ok().build();
            }
            t.get().setCodigoArea(dto.codigoArea());
            t.get().setNumero(dto.numero());
            return Response.ok().build();
        } catch (Exception e) {
            LOG.error("Requisição updateTelefone()");
            return Response.notModified(e.getMessage()).build();
        }
    }

    @Override
    public Response updateEndereco(Long id, EnderecoDTO dto) {
        try {
            LOG.info("Requisição updateEndereco()");
            Endereco e = enderecoRepository.findById(id);
            if(dto == null){
                throw new Exception("DTO vazio!!");
            }
            if(dto.cep() != null){
                e.setCep(dto.cep());
            }
            if(dto.bairro() != null){
                e.setBairro(dto.cep());
            }
            if(dto.complemento() != null){
                e.setComplemento(dto.complemento());
            }
            if(dto.idCidade() != null){
                e.setCidade(cidadeRepository.findById(dto.idCidade()));
            }
            if(dto.numero() != null){
                e.setNumero(dto.numero());
            }
            if(dto.logradouro() != null){
                e.setLogradouro(dto.logradouro());
            }
            return Response.ok().build();
        }catch (Exception e){
            LOG.error("Requisição updateEndereco()");
            return Response.notModified(e.getMessage()).build();
        }

    }

    @Override
    public UsuarioResponseDTO getPerfilUsuarioLogado() {
        try {
            LOG.info("Requisição getPerfilUsuarioLogado()");
            Usuario entity = new Usuario();
            entity = usuarioRepository.findById(jsonWebToken.getSubject());
            return new UsuarioResponseDTO(entity);

        }catch (Exception e){
            LOG.error("Erro ao rodar Requisição getPerfilUsuarioLogado()");
            return null;
        }
    }

    @Override
    @Transactional
    public Response insertTelefone(TelefoneDTO telefoneDTO) {


        try {
            LOG.info("Requisição insertTelefone()");

            return telefoneService.insert(telefoneDTO, usuarioRepository.findById(jsonWebToken.getSubject()).getId());

        }catch (Exception e){

            LOG.info("erro ao rodar Requisição insertTelefone()");
            return Response.noContent().build();
        }

    }

    @Override
    @Transactional
    public Response insertEndereco(EnderecoDTO enderecoDTO) {


        try {
            LOG.info("Requisição insertEndereco()");

            return enderecoService.insert( usuarioRepository.findById(jsonWebToken.getSubject()).getId(), enderecoDTO);

        }catch (Exception e){

            LOG.info("erro ao rodar Requisição insertEndereco()");
            return Response.noContent().build();
        }

    }

    @Override
    public Response getVendas() {

        try {
            LOG.info("Requisição getVendas()");

            Usuario entity = usuarioRepository.findById(jsonWebToken.getSubject());
            return Response.ok(vendaRepository.findAll().stream().filter(v -> v.getEndereco().getUsuario().getId() == entity.getId()).map(VendaResponseDTO::new).collect(Collectors.toList())).build();

        }catch (Exception e){

            LOG.info("erro ao rodar Requisição getVendas()");
            return Response.noContent().build();
        }
    }


    @Transactional
    @Override
    public Response deleteOn() {
        try {
            LOG.info("Requisicao delete()");

            usuarioRepository.deleteById(jsonWebToken.getSubject());
            return Response.ok().build();
        } catch (Exception e) {
            LOG.error("erro na requisicao relete() - " + e.getMessage());
            return Response.notModified("Usuario não excluido - " + e.toString()).build();
        }
    }

}
