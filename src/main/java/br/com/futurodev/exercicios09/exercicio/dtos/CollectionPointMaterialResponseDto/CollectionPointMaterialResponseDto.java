package br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto;

import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteResponseDto;

import java.math.BigDecimal;

public record CollectionPointMaterialResponseDto(
        Long id,
        ElectronicWasteResponseDto electronicWaste,
        BigDecimal maxCapacity
) {
}
