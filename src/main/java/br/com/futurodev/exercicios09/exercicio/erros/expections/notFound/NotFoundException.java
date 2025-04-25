package br.com.futurodev.exercicios09.exercicio.erros.expections.notFound;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
