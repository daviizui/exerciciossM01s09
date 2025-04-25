package br.com.futurodev.exercicios09.exercicio.erros.expections.notFound;

public class ElectronicWasteNotFoundException extends NotFoundException {
    public ElectronicWasteNotFoundException(Long id) {

        super("Electronic waste not found with id " + id);
    }
}
