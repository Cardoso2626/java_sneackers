package br.com.sneacker.sneackerjava.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musica")
    private List<Sneacker> sneackers;




    public Musica() {

    }
    public Musica(Long id, String nome, List<Sneacker> sneackers) {
        this.id = id;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
