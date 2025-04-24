package br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto;

import java.math.BigDecimal;

public record CollectionPointMaterialRequestDto(

        Long electronicWasteId,
        BigDecimal maxCapacity
) {
}
