package com.alea.pokemon.service;

import com.alea.pokemon.service.dto.PokemonInfoDTO;
import java.util.List;
import reactor.core.publisher.Mono;

public interface PokemonService {

  Mono<List<PokemonInfoDTO>> getPokemonHeaviest();

  Mono<List<PokemonInfoDTO>> getPokemonHighest();

  Mono<List<PokemonInfoDTO>> getPokemonMoreBaseExperience();
}
