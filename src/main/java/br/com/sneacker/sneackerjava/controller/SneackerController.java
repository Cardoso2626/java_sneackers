package br.com.sneacker.sneackerjava.controller;

import br.com.sneacker.sneackerjava.service.SneackerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenis")
public class SneackerController {
    public final SneackerService sneackerService;
    public SneackerController(SneackerService sneackerService) {
        this.sneackerService = sneackerService;
    }
}
