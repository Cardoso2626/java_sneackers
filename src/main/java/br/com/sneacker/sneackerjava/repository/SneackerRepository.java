package br.com.sneacker.sneackerjava.repository;

import br.com.sneacker.sneackerjava.model.Sneacker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneackerRepository extends JpaRepository<Sneacker, Long> {
}
