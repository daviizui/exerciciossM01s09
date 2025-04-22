package br.com.futurodev.exercicios09.exercicio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Setter
@Getter
@Entity
@Table(name = "collection point materials")
public class CollectionPointMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collectionPoint_id", nullable = false)
    private CollectionPoint collectionPoint;

    @ManyToOne
    @JoinColumn(name = "electronicWaste_id", nullable = false)
    private ElectronicWaste electronicWaste;

    @Column(nullable = false)
    private BigDecimal maxCapacity;
}
