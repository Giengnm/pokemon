package com.alea.pokemon.service;

import com.alea.pokemon.config.FeignConfig;
import com.alea.pokemon.service.dto.PokemonInfoDTO;
import com.alea.pokemon.service.dto.PokemonsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "${feign.pokemon.name}", url = "${feign.pokemon.url}", configuration = FeignConfig.class)
public interface PokemonClient {

  @GetMapping(value = "pokemon", consumes = "application/json", produces = "application/json")
  Mono<PokemonsDTO> getPokemonsInfo(@PathVariable(value = "limit") Integer limit);

  @GetMapping(value = "pokemon/{name}", consumes = "application/json", produces = "application/json")
  Mono<PokemonInfoDTO> getPokemonInfo(@PathVariable(value = "name") final String name);
}
