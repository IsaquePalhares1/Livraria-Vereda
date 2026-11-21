package br.com.vereda.controllers.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.vereda.dto.ExceptionDTO;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ExceptionDTO> tratarResponseStatus(ResponseStatusException ex) {

        ExceptionDTO erro = new ExceptionDTO(ex.getStatusCode().value(), ex.getReason());
        return ResponseEntity.status(ex.getStatusCode()).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> tratarArgumentosInvalidos(MethodArgumentNotValidException ex) {

        ExceptionDTO erro = new ExceptionDTO(ex.getStatusCode().value(), ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(ex.getStatusCode()).body(erro);
    }

}
