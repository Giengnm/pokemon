package com.alea.pokemon.service.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.alea.pokemon.common.exception.CodeException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class OtherExceptionTest {

  public static final String EXCEPTION = "Exception";

  @Test
  void test() {
    OtherException otherException = null;

    assertNull(otherException);

    otherException = new OtherException(CodeException.ERR_0001, EXCEPTION);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, otherException.getHttpStatusCode());
    assertEquals(EXCEPTION, otherException.getDescription());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), otherException.getCode());

  }
}