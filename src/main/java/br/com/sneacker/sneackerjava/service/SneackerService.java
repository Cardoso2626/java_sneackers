package br.com.sneacker.sneackerjava.service;

import br.com.sneacker.sneackerjava.dto.SneackerRequest;
import br.com.sneacker.sneackerjava.dto.SneackerResponse;
import br.com.sneacker.sneackerjava.model.Musica;
import br.com.sneacker.sneackerjava.model.Sneacker;
import br.com.sneacker.sneackerjava.model.Usuario;
import br.com.sneacker.sneackerjava.repository.MusicaRepository;
import br.com.sneacker.sneackerjava.repository.SneackerRepository;
import br.com.sneacker.sneackerjava.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SneackerService {
    public final SneackerRepository sneackerRepository;
    public final UsuarioRepository usuarioRepository;
    public final MusicaRepository musicaRepository;
    public SneackerService(SneackerRepository sneackerRepository, UsuarioRepository usuarioRepository, MusicaRepository musicaRepository) {
        this.sneackerRepository = sneackerRepository;
        this.usuarioRepository = usuarioRepository;
        this.musicaRepository = musicaRepository;
    }

    public List<SneackerResponse> listarSneackers(){
        List<Sneacker> sneackers = sneackerRepository.findAll();
        return sneackers.stream()
                .map(s -> new SneackerResponse(
                        s.getId(),
                        s.getNome(),
                        s.getMarca(),
                        s.getPreco(),
                        s.getAdquirido(),
                        s.getMusica() != null ? s.getMusica().getNome() : null,
                        s.getUsuario() != null ? s.getUsuario().getEmail() : null
                )).collect(Collectors.toList());
    }

    public SneackerResponse criarSneacer(SneackerRequest sneackerRequest, String nomeMusica, String emailUsuario) {
        Sneacker sneacker = new Sneacker();
        sneacker.setNome(sneackerRequest.getNome());
        sneacker.setMarca(sneackerRequest.getMarca());
        sneacker.setPreco(sneackerRequest.getPreco());
        sneacker.setAdquirido(sneackerRequest.getAdquirido());
        if (sneackerRequest.getNomeMusica() != null){
            Musica musica = musicaRepository.findByNome(nomeMusica).orElseThrow(() -> new RuntimeException ("Não foi possível encontrar a música: " + nomeMusica));
            sneacker.setMusica(musica);
        } else{
            sneacker.setMusica(null);
        }
        if (sneackerRequest.getEmailUsuario() != null) {
            Usuario usuario = usuarioRepository.findByEmail(emailUsuario).orElseThrow(() -> new RuntimeException("O usuário não pode ser encontrado: " + emailUsuario));
            sneacker.setUsuario(usuario);
        }else{
            sneacker.setUsuario(null);
        }

        sneacker = sneackerRepository.save(sneacker);

        return new SneackerResponse(
                sneacker.getId(),
                sneacker.getNome(),
                sneacker.getMarca(),
                sneacker.getPreco(),
                sneacker.getAdquirido(),
                sneacker.getMusica() != null ? sneacker.getMusica().getNome() : null,
                sneacker.getUsuario() != null ? sneacker.getUsuario().getEmail() : null
        );

    }
}
