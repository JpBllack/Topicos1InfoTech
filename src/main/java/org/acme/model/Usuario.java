package org.acme.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends DefaultyEntity {
    
    
    @NotBlank(message = "O campo 'nome' não pode estar em branco")
    @Size(max = 100, message = "O campo 'nome' deve ter no máximo 100 caracteres")
    @Size(min = 3, message = "O campo 'nome' deve ter no minimo 3 caracteres")
    private String nome;

    @NotBlank(message = "O campo 'login' não pode estar em branco")
    @Size(max = 50, message = "O campo 'login' deve ter no máximo 50 caracteres")
    private String login;

    @NotBlank(message = "O campo 'email' não pode estar em branco")
    @Size(max = 100, message = "O campo 'login' deve ter no máximo 100 caracteres")
    private String email;

    @NotBlank(message = "O campo 'senha' não pode estar em branco")
    private String senha;

    
    @Column
    @NotBlank(message = "O campo 'cpf' não pode estar em branco")
    @Size(max = 16, message = "O campo 'cpf' deve ter no máximo 50 caracteres")
    private String cpf;

    @ElementCollection
    @CollectionTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"))
    @Column(name = "perfil", length = 30)
    private Set<Perfil> perfis;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Set<Perfil> perfis) {
        this.perfis = perfis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}

