package br.com.sneacker.sneackerjava.service;

import br.com.sneacker.sneackerjava.repository.SneackerRepository;
import org.springframework.stereotype.Service;

@Service
public class SneackerService {
    public final SneackerRepository sneackerRepository;
    public SneackerService(SneackerRepository sneackerRepository) {
        this.sneackerRepository = sneackerRepository;
    }
}
