package br.unitins.topicos1.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario extends DefalutEntity {
    
      @NotBlank(message = "O campo 'nome' não pode estar em branco")
    @Size(max = 100, message = "O campo 'nome' deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "O campo 'login' não pode estar em branco")
    @Size(max = 50, message = "O campo 'login' deve ter no máximo 50 caracteres")
    private String login;

    @NotBlank(message = "O campo 'senha' não pode estar em branco")
    @Size(max = 50, message = "O campo 'senha' deve ter no máximo 50 caracteres")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true)
    @JoinTable(name="usuario_telefone", joinColumns = @JoinColumn (name= "id_usuario"), inverseJoinColumns = @JoinColumn(name= "id_telefone") )
    private List<Telefone> listaTelefone;
    
    private Perfil perfil;


 

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    
}
