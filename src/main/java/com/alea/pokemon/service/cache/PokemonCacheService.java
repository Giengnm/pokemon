package com.alea.pokemon.service.cache;

import static com.alea.pokemon.common.exception.CodeException.ERR_0001;
import static com.alea.pokemon.common.exception.CodeException.ERR_0002;

import com.alea.pokemon.api.exception.NotFoundException;
import com.alea.pokemon.service.PokemonClient;
import com.alea.pokemon.service.dto.PokemonInfoDTO;
import com.alea.pokemon.service.dto.PokemonsDTO;
import com.alea.pokemon.service.exception.OtherException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokemonCacheService {

  private PokemonClient pokemonClient;

  public PokemonCacheService(PokemonClient pokemonClient) {
    this.pokemonClient = pokemonClient;
  }

  private Mono<PokemonsDTO> getPokemon() {
    return pokemonClient.getPokemonsInfo(null)
        .onErrorResume(e -> Mono.error(new OtherException(ERR_0002, e.getMessage())))
        .switchIfEmpty(Mono.error(new NotFoundException(ERR_0001)))
        .flatMap(result -> pokemonClient.getPokemonsInfo(result.getCount()));
  }

  @Cacheable("pokemons")
  public Flux<PokemonInfoDTO> getAllPokemonInfo() {
    return this.getPokemon()
        .map(PokemonsDTO::getResults)
        .flatMapIterable(list -> list)
        .flatMap(pokemon -> pokemonClient.getPokemonInfo(pokemon.getName()))
        .onErrorResume(e -> Mono.error(new OtherException(ERR_0002, e.getMessage())))
        .cache();
  }
}
