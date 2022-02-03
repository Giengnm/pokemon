package com.alea.pokemon.service.exception;

import com.alea.pokemon.common.exception.CodeException;
import org.springframework.http.HttpStatus;

@SuppressWarnings({"java:S110"})
public class ServerException extends ResponseException {

  private static final HttpStatus status = HttpStatus.CONFLICT;

  public ServerException(CodeException exception) {
    super(status.value(), exception.getCode(), exception.getDescription());
  }

  @Override
  public HttpStatus getHttpStatusCode() {
    return status;
  }
}