package com.alea.pokemon.service.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.alea.pokemon.common.exception.CodeException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ServerExceptionTest {

  public static final String EXCEPTION = "Exception";

  @Test
  void test() {
    ServerException serverException = null;

    assertNull(serverException);

    serverException = new ServerException(CodeException.ERR_0001);

    assertEquals(HttpStatus.CONFLICT, serverException.getHttpStatusCode());
    assertEquals(CodeException.ERR_0001.getDescription(), serverException.getDescription());
    assertEquals(HttpStatus.CONFLICT.value(), serverException.getCode());

  }
}