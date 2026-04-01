package br.com.sneacker.sneackerjava.service;

import br.com.sneacker.sneackerjava.repository.MusicaRepository;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {
    public final MusicaRepository musicaRepository;
    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
    }
}
