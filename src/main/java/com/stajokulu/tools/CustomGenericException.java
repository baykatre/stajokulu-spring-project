package com.stajokulu.tools;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.Optional;

@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CustomGenericException extends RuntimeException {

  private static final String UNKNOWN_ERROR = "Bilinmeyen Hata!";

  private final HttpStatus code;
  private final String[] messages;

  public CustomGenericException() {

    this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    this.messages = new String[] {UNKNOWN_ERROR};
  }

  public CustomGenericException(String... messages) {

    this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    this.messages = messages;
  }

  public CustomGenericException(Exception e) {

    this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    this.messages = new String[] {UNKNOWN_ERROR};
  }

  public CustomGenericException(String message) {

    this.code = HttpStatus.INTERNAL_SERVER_ERROR;
    this.messages = new String[] {message};
  }

  public Optional<HttpStatus> getErrorCode() {

    return Optional.ofNullable(this.code);
  }

  public Optional<String[]> getMessages() {

    return Optional.ofNullable(this.messages);
  }
}
