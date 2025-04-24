package br.com.futurodev.exercicios09.exercicio.repositories;

import br.com.futurodev.exercicios09.exercicio.entities.CollectionPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CollectionPointRepository extends JpaRepository<CollectionPoint, Long> {

   @Query("SELECT DISTINCT cp.collectionPoint FROM CollectionPointMaterial cp WHERE UPPER(cp.electronicWaste.type) LIKE '%' || UPPER(:name) || '%'")
    List<CollectionPoint> findAllByName(String name);
}
