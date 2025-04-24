package br.com.futurodev.exercicios09.exercicio.services;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointResponseDto;

import java.util.List;

public interface CollectionPointService {

    List<CollectionPointResponseDto> findAll();
    CollectionPointResponseDto findById(Long id);
    CollectionPointResponseDto create(CollectionPointRequestDto dto);
    CollectionPointResponseDto update(Long id, CollectionPointRequestDto dto);
    void delete(Long id);
}
