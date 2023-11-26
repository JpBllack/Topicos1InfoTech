package org.acme.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.acme.dto.*;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.service.HashService;
import org.acme.service.UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    UsuarioRepository repository;

    @Inject
    UsuarioService service;

    @Inject
    HashService hash;

    @Override
    public List<UsuarioResponseDTO> getAll() {
        return repository.findAll().stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO getId(long id) {
        return new UsuarioResponseDTO(repository.findById(id));
    }

    @Override
    public Usuario findByLoginAndSenha(String login, String senha) {
        String s = hash.getHashSenha(senha);
        Usuario usuario = new Usuario();
        usuario = repository.findByEmailAndSenha(login, s);
        if(usuario == null){
            usuario = repository.findByLoginAndSenha(login, s);
        }
        return usuario;
    }

    @Override
    public List<UsuarioResponseDTO> getNome(String nome) {
        return repository.findByNome(nome).stream().map(UsuarioResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO updateEmail(Long id, UsuarioUpdateEmailDTO email) {
        Usuario u = new Usuario();
        u = repository.findById(id);
        u.setEmail(email.email());
        return new UsuarioResponseDTO(u);
    }

    @Override
    public UsuarioResponseDTO updateNome(Long id, UsuarioUpdateNomeDTO nome) {
        Usuario u = new Usuario();
        u = repository.findById(id);
        u.setEmail(nome.nome());
        return new UsuarioResponseDTO(u);
    }

    @Transactional
    @Override
    public UsuarioResponseDTO updateLogin(Long id, UsuarioUpdateLoginDTO login) {
        Usuario u = new Usuario();
        u = repository.findById(id);
        u.setEmail(login.login());
        return new UsuarioResponseDTO(u);
    }

    @Transactional
    @Override
    public UsuarioResponseDTO updateSenha(MudarSenhaDTO senha) {
        Usuario u = new Usuario();
        u = service.findByLoginAndSenha(senha.login(), senha.senhaAntiga());
        u.setSenha(hash.getHashSenha(senha.novaSenha()));
        return new UsuarioResponseDTO(u);
    }

    @Transactional
    @Override
    public Response insert(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setNome(dto.nome());
        u.setCpf(dto.cpf());
        u.setEmail(dto.email());
        u.setSenha(hash.getHashSenha(dto.senha()));
        return Response.ok(new UsuarioResponseDTO(u)).build();
    }

    @Transactional
    @Override
    public Response delete(Long id) {
        Usuario u = new Usuario();
        u = repository.findById(id);
        repository.deleteById(u.getId());
        return Response.ok().build();
    }
}
