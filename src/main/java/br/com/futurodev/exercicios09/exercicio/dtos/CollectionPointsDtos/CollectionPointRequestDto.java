package br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto.CollectionPointMaterialRequestDto;

import java.util.List;

public record CollectionPointRequestDto(
        String name,
        String address,
        String collectionDay,
        List<CollectionPointMaterialRequestDto> materials
) {
}
