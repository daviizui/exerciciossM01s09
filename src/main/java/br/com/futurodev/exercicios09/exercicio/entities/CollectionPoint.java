package br.com.futurodev.exercicios09.exercicio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "collection points")
public class CollectionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String collectionDay;

    @OneToMany(mappedBy = "collectionPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionPointMaterial> materials = new ArrayList<>();
}
