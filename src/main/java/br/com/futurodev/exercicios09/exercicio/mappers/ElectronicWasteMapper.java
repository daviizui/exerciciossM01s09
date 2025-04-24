package br.com.futurodev.exercicios09.exercicio.mappers;

import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.ElectronicWaste;

import java.util.List;


public class ElectronicWasteMapper {

    private ElectronicWasteMapper() {}

    public static ElectronicWaste toEntity(ElectronicWaste entity, ElectronicWasteRequestDto dto) {
        entity.setType(dto.type());
        entity.setDescription(dto.description());
        return entity;
    }

    public static ElectronicWasteResponseDto toResponseDto(ElectronicWaste entity) {
        return new ElectronicWasteResponseDto(
                entity.getId(),
                entity.getType(),
                entity.getDescription()
        );
    }

    public static List <ElectronicWasteResponseDto> toResponseDtos(List<ElectronicWaste> entities) {
       return entities.stream().map(ElectronicWasteMapper ::toResponseDto).toList();
    }
}