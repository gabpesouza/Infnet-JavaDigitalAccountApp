package br.edu.infnet.appgabrielpereira.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionDto> handleNullPointerException(NullPointerException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionDto(exception.getMessage(), HttpStatus.BAD_REQUEST.value())
        );
    }
}
