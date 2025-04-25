package br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest;

public class CollectionPointMaterialRequiredAttributeException extends RequiredAttributeException {
    public CollectionPointMaterialRequiredAttributeException(String attribute) {
        super("Collection point material", attribute);
    }
}
