package com.alea.pokemon.service.exception;

import com.alea.pokemon.common.exception.CodeException;
import org.springframework.http.HttpStatus;

@SuppressWarnings({"java:S110"})
public class OtherException extends ResponseException {

  private static final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

  public OtherException(CodeException exception, String description) {
    super(status.value(), exception.getCode(), description);
  }

  @Override
  public HttpStatus getHttpStatusCode() {
    return status;
  }
}