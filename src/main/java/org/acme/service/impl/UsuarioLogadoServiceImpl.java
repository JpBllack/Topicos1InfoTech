package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.service.HashService;
import org.acme.service.UsuarioLogadoService;
import org.eclipse.microprofile.jwt.JsonWebToken;

@ApplicationScoped
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    @Inject
    JsonWebToken jsonWebToken;

    @Inject
    UsuarioRepository usuarioRepository;
    @Inject
    HashService hash;

    @Transactional
    @Override
    public UsuarioResponseDTO updateSenha(MudarSenhaDTO senha) {
        try {

            Usuario entity = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());

            if(hash.getHashSenha(senha.senhaAntiga()) != entity.getSenha())
                throw new Exception("Senha anterior Incorreta");

            entity.setSenha(hash.getHashSenha(senha.novaSenha()));
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public UsuarioResponseDTO updateLogin(UsuarioUpdateLoginDTO login) {
        try {

            Usuario entity = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());

            entity.setLogin(login.login());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public UsuarioResponseDTO updateNome(UsuarioUpdateNomeDTO nome) {
        try {

            Usuario entity = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());

            entity.setNome(nome.nome());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public UsuarioResponseDTO updateEmail(UsuarioUpdateEmailDTO email) {
        try {

            Usuario entity = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());

            entity.setEmail(email.email());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UsuarioResponseDTO getPerfilUsuarioLogado() {
        try {

            Usuario entity = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());
            return new UsuarioResponseDTO(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public Response deleteOn() {
        try {

            Usuario entity = usuarioRepository.findByIdModificado(jsonWebToken.getSubject());

            usuarioRepository.delete(entity);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.notModified("Usuario não excluido - " + e.toString()).build();
        }
    }

}
