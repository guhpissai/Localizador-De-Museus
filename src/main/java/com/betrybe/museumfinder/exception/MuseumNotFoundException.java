package com.betrybe.museumfinder.exception;

/**
 * Representa uma excessão caso não seja encontrado um Museu.
 */
public class MuseumNotFoundException extends RuntimeException {

  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }
}
