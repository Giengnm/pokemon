package com.alea.pokemon.api.impl;

import io.swagger.v3.oas.annotations.Operation;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RootController {

  @GetMapping("/")
  @Operation(summary = "Redirect To Swagger INFO",
      description = "This endpoint is redirecting to Swagger INFO.")
  public Mono<Void> indexController(ServerHttpResponse response) {
    response.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
    response.getHeaders().setLocation(URI.create("/swagger-ui.html"));
    return response.setComplete();
  }
}
