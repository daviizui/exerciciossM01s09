package br.com.futurodev.exercicios09.exercicio.repositories;

import br.com.futurodev.exercicios09.exercicio.entities.CollectionPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {
}
