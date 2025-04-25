package br.com.futurodev.exercicios09.exercicio.dtos.errors;

public record ErrosResponseDto(
        String code,
        String message,
        String cause,
        String exceptionClassName
) {
}
