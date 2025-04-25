package br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest;

public class CollectionPointRequiredAttributeException extends RequiredAttributeException {
    public CollectionPointRequiredAttributeException(String attribute) {
        super("Collection point", attribute);
    }
}
