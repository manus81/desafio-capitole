package com.capitole.desafio.domain.exceptions;

public class PriceNotFoundException extends RuntimeException {
  public PriceNotFoundException(String message) {
    super(message);
  }
}
