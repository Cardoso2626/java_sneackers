package br.com.sneacker.sneackerjava.controller;

import br.com.sneacker.sneackerjava.service.MusicaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musica")
public class MusicaController {
    public final MusicaService musicaService;
    public MusicaController(MusicaService musicaService) {
        this.musicaService = musicaService;
    }
}
