package br.com.sneacker.sneackerjava.controller;

import br.com.sneacker.sneackerjava.dto.MusicaRequest;
import br.com.sneacker.sneackerjava.dto.MusicaResponse;
import br.com.sneacker.sneackerjava.model.Musica;
import br.com.sneacker.sneackerjava.service.MusicaService;
import br.com.sneacker.sneackerjava.service.SneackerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    public final MusicaService musicaService;
    public final SneackerService sneackerService;
    public MusicaController(MusicaService musicaService, SneackerService sneackerService) {
        this.musicaService = musicaService;
        this.sneackerService = sneackerService;
    }



}
