package br.com.sneacker.sneackerjava.repository;

import br.com.sneacker.sneackerjava.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    Optional<Musica> findByNome(String nome);
}
