package br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto.CollectionPointMaterialResponseDto;

import java.util.List;

public record CollectionPointResponseDto(
        Long id,
        String name,
        String address,
        String collectionDay,
        List<CollectionPointMaterialResponseDto> materials
) {
}
