package br.com.sneacker.sneackerjava.dto;

public record SneackerResponse(Long id, String nome, String marca, Double preco, Boolean adquirido, String nomeMusica, String emailUsuario ) {
}
