package br.com.futurodev.exercicios09.exercicio.mappers;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPoint;
import br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest.CollectionPointRequiredAttributeException;

import java.util.List;


public class CollectionPointMapper {

    private CollectionPointMapper() {}

    public static CollectionPoint toEntity(CollectionPoint entity, CollectionPointRequestDto dto) {
        entity.setName(dto.name());
        entity.setAddress(dto.address());
        entity.setCollectionDay(dto.collectionDay());
        return entity;
    }

    public static CollectionPointResponseDto toResponseDto(CollectionPoint entity) {
        return new CollectionPointResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getCollectionDay(),
                CollectionPointMaterialMapper.toResponseDtos(entity.getMaterials())

        );
    }

    public static List <CollectionPointResponseDto> toResponseDtos(List<CollectionPoint> entities) {
       return entities.stream().map(CollectionPointMapper::toResponseDto).toList();
    }



}