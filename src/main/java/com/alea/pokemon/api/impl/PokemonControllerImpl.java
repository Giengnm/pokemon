package com.alea.pokemon.api.impl;

import static com.alea.pokemon.common.exception.CodeException.ERR_0001;

import com.alea.pokemon.api.PokemonController;
import com.alea.pokemon.api.exception.NotFoundException;
import com.alea.pokemon.service.PokemonService;
import com.alea.pokemon.service.dto.PokemonInfoDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class PokemonControllerImpl implements PokemonController {

  private PokemonService pokemonService;

  public PokemonControllerImpl(PokemonService pokemonService) {
    this.pokemonService = pokemonService;
  }

  @Override
  public Mono<ResponseEntity<List<PokemonInfoDTO>>> getPokemonHeaviest() {
    return pokemonService.getPokemonHeaviest()
        .switchIfEmpty(Mono.error(new NotFoundException(ERR_0001)))
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<List<PokemonInfoDTO>>> getPokemonHighest() {
    return pokemonService.getPokemonHighest()
        .switchIfEmpty(Mono.error(new NotFoundException(ERR_0001)))
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<List<PokemonInfoDTO>>> getPokemonMoreBaseExperience() {
    return pokemonService.getPokemonMoreBaseExperience()
        .switchIfEmpty(Mono.error(new NotFoundException(ERR_0001)))
        .map(ResponseEntity::ok);
  }
}
