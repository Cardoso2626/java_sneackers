package br.com.sneacker.sneackerjava.service;

import br.com.sneacker.sneackerjava.repository.UsuarioRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioService {
    public final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
