package br.com.sneacker.sneackerjava.service;

import br.com.sneacker.sneackerjava.dto.MusicaRequest;
import br.com.sneacker.sneackerjava.dto.MusicaResponse;
import br.com.sneacker.sneackerjava.model.Musica;
import br.com.sneacker.sneackerjava.model.Sneacker;
import br.com.sneacker.sneackerjava.repository.MusicaRepository;
import br.com.sneacker.sneackerjava.repository.SneackerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaService {
    public final MusicaRepository musicaRepository;
    public final SneackerRepository sneackerRepository;
    public MusicaService(MusicaRepository musicaRepository, SneackerRepository sneackerRepository) {
        this.musicaRepository = musicaRepository;
        this.sneackerRepository = sneackerRepository;
    }

    public MusicaResponse criarMusica(MusicaRequest musicaRequest, List<Long> ids) {
        Musica musica = new Musica();
        musica.setNome(musicaRequest.nome());
        List<Long> idSneackers = new ArrayList<>();
        if(musicaRequest.idSneackers() != null) {
            List<Sneacker> sneackers =  sneackerRepository.findAllById(ids);
            idSneackers = sneackers.stream().map(Sneacker::getId).collect(Collectors.toList());
            musica.setSneackers(sneackers);
        }else{
            musica.setSneackers(null);
        }
        musica = musicaRepository.save(musica);
        return new MusicaResponse(
                musica.getNome(),
                idSneackers
        );

    }
}
