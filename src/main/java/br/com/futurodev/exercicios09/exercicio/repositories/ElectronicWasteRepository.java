package br.com.futurodev.exercicios09.exercicio.repositories;

import br.com.futurodev.exercicios09.exercicio.entities.ElectronicWaste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicWasteRepository extends JpaRepository<ElectronicWaste, Long> {
}
