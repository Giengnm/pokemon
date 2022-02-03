package com.alea.pokemon.service.impl;

import static com.alea.pokemon.common.exception.CodeException.ERR_0002;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_ID;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_NAME;
import static org.mockito.Mockito.when;

import com.alea.pokemon.service.cache.PokemonCacheService;
import com.alea.pokemon.service.dto.PokemonInfoDTO;
import com.alea.pokemon.service.exception.ServerException;
import com.alea.pokemon.service.utilities.PokemonUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class PokemonServiceImplTest {

  @Mock
  private static PokemonCacheService pokemonCacheService;

  @InjectMocks
  private PokemonServiceImpl service;

  @Test
  void test_getPokemonHeaviestReturnServerException() {
    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(Flux.error(new ServerException(ERR_0002)));
    StepVerifier.create(service.getPokemonHeaviest())
        .expectError(ServerException.class)
        .verify();
  }

  @Test
  void test_getPokemonHighestReturnServerException() {
    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(Flux.error(new ServerException(ERR_0002)));
    StepVerifier.create(service.getPokemonHighest())
        .expectError(ServerException.class)
        .verify();
  }

  @Test
  void test_getPokemonMoreBaseExperienceReturnServerException() {
    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(Flux.error(new ServerException(ERR_0002)));
    StepVerifier.create(service.getPokemonMoreBaseExperience())
        .expectError(ServerException.class)
        .verify();
  }

  @Test
  void test_getPokemonHeaviestReturnCollectionEmpty() {
    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(Flux.empty());
    StepVerifier.create(service.getPokemonHeaviest())
        .expectError(ServerException.class)
        .verify();
  }

  @Test
  void test_getPokemonHighestReturnCollectionEmpty() {
    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(Flux.empty());
    StepVerifier.create(service.getPokemonHighest())
        .expectError(ServerException.class)
        .verify();
  }

  @Test
  void test_getPokemonMoreBaseExperienceReturnCollectionEmptyData() {
    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(Flux.empty());
    StepVerifier.create(service.getPokemonMoreBaseExperience())
        .expectError(ServerException.class)
        .verify();
  }

  @Test
  void test_getPokemonHeaviestReturnCollectionWithData() {
    prepareCacheEmptyListWithData();
    StepVerifier.create(service.getPokemonHeaviest())
        .expectNextMatches(PokemonUtilities::validateListOfPokemonHeaviest)
        .verifyComplete();
  }

  @Test
  void test_getPokemonHighestReturnCollectionWithData() {
    prepareCacheEmptyListWithData();
    StepVerifier.create(service.getPokemonHighest())
        .expectNextMatches(PokemonUtilities::validateListOfPokemonHighest)
        .verifyComplete();
  }

  @Test
  void test_getPokemonMoreBaseExperienceReturnCollectionWithData() {
    prepareCacheEmptyListWithData();
    StepVerifier.create(service.getPokemonMoreBaseExperience())
        .expectNextMatches(PokemonUtilities::validateListOfPokemonMoreBaseExperience)
        .verifyComplete();
  }

  private void prepareCacheEmptyListWithData() {

    when(pokemonCacheService.getAllPokemonInfo())
        .thenReturn(getFluxOfPokemonInfoDTOForHighest());
  }

  private Flux<PokemonInfoDTO> getFluxOfPokemonInfoDTOForHighest() {

    return Flux.range(1, 10).map(this::newPokemonInfoDtoForHighest);
  }

  private PokemonInfoDTO newPokemonInfoDtoForHighest(Integer value) {
    PokemonInfoDTO pokemon = new PokemonInfoDTO();
    pokemon.setId(POKEMON_ID);
    pokemon.setName(POKEMON_NAME + value);
    pokemon.setHeight(value);
    pokemon.setBaseExperience(value);
    pokemon.setWeight(value);

    pokemon.setOrder(10 - value);

    return pokemon;
  }


}