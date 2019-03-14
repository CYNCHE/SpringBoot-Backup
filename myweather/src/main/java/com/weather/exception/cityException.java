package com.weather.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class cityException extends RuntimeException {
  public cityException() {
  }

  public cityException(String message) {
    super(message);
  }

  public cityException(String message, Throwable cause) {
    super(message, cause);
  }
}
