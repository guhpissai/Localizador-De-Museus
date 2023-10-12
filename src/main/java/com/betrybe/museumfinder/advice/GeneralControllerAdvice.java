package com.betrybe.museumfinder.advice;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Classe de controle de exceções global para lidar com exceções específicas da aplicação.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Manipula exceções do tipo InvalidCoordinateException e retorna uma resposta com status 400 (BAD
   * REQUEST) e a mensagem da exceção.
   *
   * @param exception A exceção InvalidCoordinateException lançada na aplicação.
   * @return Uma ResponseEntity com status 400 e a mensagem da exceção.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinateException(
      InvalidCoordinateException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }

  /**
   * Manipula exceções do tipo MuseumNotFoundException e retorna uma resposta com status 404 (NOT
   * FOUND) e a mensagem da exceção.
   *
   * @param exception A exceção MuseumNotFoundException lançada na aplicação.
   * @return Uma ResponseEntity com status 404 e a mensagem da exceção.
   */
  @ExceptionHandler(MuseumNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFoundException(
      MuseumNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  /**
   * Manipula exceções do tipo Exception (ou subclasses) e retorna uma resposta com status 500
   * (INTERNAL SERVER ERROR) e uma mensagem genérica indicando que ocorreu um erro interno do
   * servidor.
   *
   * @param exception A exceção geral lançada na aplicação.
   * @return Uma ResponseEntity com status 500 e uma mensagem de erro genérica.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleOtherExceptions(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Erro interno!");
  }
}
