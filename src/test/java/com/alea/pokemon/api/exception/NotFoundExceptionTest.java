package com.alea.pokemon.api.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.alea.pokemon.common.exception.CodeException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class NotFoundExceptionTest {

  @Test
  void test() {
    NotFoundException notFoundException = null;

    assertNull(notFoundException);

    notFoundException = new NotFoundException(CodeException.ERR_0001);

    assertEquals(HttpStatus.NOT_FOUND, notFoundException.getHttpStatusCode());
    assertEquals(HttpStatus.NOT_FOUND.value(), notFoundException.getCode());

  }

}