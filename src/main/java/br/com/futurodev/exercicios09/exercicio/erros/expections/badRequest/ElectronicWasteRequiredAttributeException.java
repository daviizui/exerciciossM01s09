package br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest;

public class ElectronicWasteRequiredAttributeException extends RequiredAttributeException {
    public ElectronicWasteRequiredAttributeException(String attribute) {
        super("Electronic waste", attribute);
    }
}
