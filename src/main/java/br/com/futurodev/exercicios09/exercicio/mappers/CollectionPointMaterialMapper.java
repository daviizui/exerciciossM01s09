package br.com.futurodev.exercicios09.exercicio.mappers;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto.CollectionPointMaterialRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto.CollectionPointMaterialResponseDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPoint;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPointMaterial;

import java.util.List;


public class CollectionPointMaterialMapper {


    public static CollectionPointMaterialResponseDto toResponseDto(CollectionPointMaterial entity) {
        return new CollectionPointMaterialResponseDto(
                entity.getId(),
                ElectronicWasteMapper.toResponseDto(entity.getElectronicWaste()),
                entity.getMaxCapacity()
        );
    }

    public static List <CollectionPointMaterialResponseDto> toResponseDtos(List<CollectionPointMaterial> entities) {
       return entities.stream().map(CollectionPointMaterialMapper::toResponseDto).toList();
    }
}