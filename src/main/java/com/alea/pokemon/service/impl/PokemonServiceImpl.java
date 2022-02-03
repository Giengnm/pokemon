package com.alea.pokemon.service.impl;

import static com.alea.pokemon.common.Constants.INTEGER_DEFAULT;
import static com.alea.pokemon.common.exception.CodeException.ERR_0003;
import static com.alea.pokemon.common.exception.CodeException.ERR_0004;
import static com.alea.pokemon.common.exception.CodeException.ERR_0005;

import com.alea.pokemon.service.PokemonService;
import com.alea.pokemon.service.cache.PokemonCacheService;
import com.alea.pokemon.service.dto.PokemonInfoDTO;
import com.alea.pokemon.service.exception.ServerException;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

  private PokemonCacheService pokemonCacheService;

  public PokemonServiceImpl(final PokemonCacheService pokemonCacheService) {
    this.pokemonCacheService = pokemonCacheService;
  }

  @Override
  public Mono<List<PokemonInfoDTO>> getPokemonHeaviest() {
    return pokemonCache()
        .filter(pokemon -> ObjectUtils.allNotNull(pokemon.getWeight()))
        .sort(this::compareWeight)
        .switchIfEmpty(Mono.error(new ServerException(ERR_0003)))
        .collectList()
        .map(list -> list.subList(0, Math.min(5, list.size())));
  }

  @Override
  public Mono<List<PokemonInfoDTO>> getPokemonHighest() {
    return pokemonCache()
        .filter(pokemon -> ObjectUtils.allNotNull(pokemon.getHeight()))
        .sort(this::compareHeight)
        .switchIfEmpty(Mono.error(new ServerException(ERR_0004)))
        .collectList()
        .map(list -> list.subList(0, Math.min(5, list.size())));
  }

  @Override
  public Mono<List<PokemonInfoDTO>> getPokemonMoreBaseExperience() {
    return pokemonCache()
        .filter(pokemon -> ObjectUtils.allNotNull(pokemon.getBaseExperience()))
        .sort(this::compareBaseExperience)
        .switchIfEmpty(Mono.error(new ServerException(ERR_0005)))
        .collectList()
        .map(list -> list.subList(0, Math.min(5, list.size())));
  }

  private int compareHeight(PokemonInfoDTO pokemonInfoDTO, PokemonInfoDTO pokemonInfoDTO1) {
    return defaultZero(pokemonInfoDTO1.getHeight())
        .compareTo(defaultZero(pokemonInfoDTO.getHeight()));
  }

  private int compareWeight(PokemonInfoDTO pokemonInfoDTO, PokemonInfoDTO pokemonInfoDTO1) {
    return defaultZero(pokemonInfoDTO1.getWeight())
        .compareTo(defaultZero(pokemonInfoDTO.getWeight()));
  }

  private int compareBaseExperience(PokemonInfoDTO pokemonInfoDTO, PokemonInfoDTO pokemonInfoDTO1) {
    return defaultZero(pokemonInfoDTO1.getBaseExperience())
        .compareTo(defaultZero(pokemonInfoDTO.getBaseExperience()));
  }

  private Integer defaultZero(Integer value) {
    return Optional.ofNullable(value).orElse(INTEGER_DEFAULT);
  }

  private Flux<PokemonInfoDTO> pokemonCache() {
    return pokemonCacheService.getAllPokemonInfo();
  }

}
