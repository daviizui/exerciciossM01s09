package br.com.futurodev.exercicios09.exercicio.erros.expections.notFound;

public class CollectionPointNotFoundException extends NotFoundException {
  public CollectionPointNotFoundException(Long id) {
    super("Collection point not found with id " + id);
  }
}
