package br.com.futurodev.exercicios09.exercicio.erros;

import br.com.futurodev.exercicios09.exercicio.dtos.errors.ErrosResponseDto;
import br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest.RequiredAttributeException;
import br.com.futurodev.exercicios09.exercicio.erros.expections.notFound.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrosResponseDto> handle(Exception e) {
        return ResponseEntity.internalServerError().body(new ErrosResponseDto(
                "500",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getName()
        ));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrosResponseDto> handle(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrosResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getName()
        ));
    }

    @ExceptionHandler(RequiredAttributeException.class)
    public ResponseEntity<ErrosResponseDto> handle(RequiredAttributeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrosResponseDto(
                "404",
                e.getLocalizedMessage(),
                e.getCause() != null ? e.getCause().getLocalizedMessage() : null,
                e.getClass().getName()
        ));
    }
}
