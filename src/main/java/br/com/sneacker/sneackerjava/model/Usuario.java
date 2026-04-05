package br.com.sneacker.sneackerjava.model;

import jakarta.persistence.*;
import org.springframework.resilience.annotation.EnableResilientMethods;

import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nomeCompleto;
    private String cpf;
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Sneacker> sneackers;


    public Usuario() {

    }

    public Usuario(Long id, String email, String nomeCompleto, String cpf, String senha, List<Sneacker> sneackers) {
        this.id = id;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.senha = senha;
        this.sneackers = sneackers;
    }


    public List<Sneacker> getSneackers() {
        return sneackers;
    }

    public void setSneackers(List<Sneacker> sneackers) {
        this.sneackers = sneackers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
