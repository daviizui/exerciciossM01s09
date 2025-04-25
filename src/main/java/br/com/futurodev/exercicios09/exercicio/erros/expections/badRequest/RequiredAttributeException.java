package br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest;

public class RequiredAttributeException extends RuntimeException {
    public RequiredAttributeException(String  objectName, String attribute) {
        super("Required attribute '" + objectName + "." + attribute + "' not found");
    }


}
