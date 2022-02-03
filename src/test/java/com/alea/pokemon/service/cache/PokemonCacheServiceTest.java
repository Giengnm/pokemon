package com.alea.pokemon.service.cache;

import static com.alea.pokemon.service.utilities.PokemonUtilities.getMonoOfEmptyPokemonsDTO;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getMonoOfPokemonInfoDTO;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getMonoOfPokemonsDTO;
import static org.mockito.Mockito.when;

import com.alea.pokemon.service.PokemonClient;
import com.alea.pokemon.service.exception.OtherException;
import com.alea.pokemon.service.utilities.PokemonUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class PokemonCacheServiceTest {

  @Mock
  private PokemonClient pokemonClient;

  @InjectMocks
  private PokemonCacheService pokemonCacheService;

  @BeforeAll
  static void init() {

  }

  @Test
  void test_getPokemonsInfoException() {
    when(pokemonClient.getPokemonsInfo(null)).thenReturn(Mono.empty());
    StepVerifier.create(pokemonCacheService.getAllPokemonInfo())
        .expectError(OtherException.class)
        .verify();
  }

  @Test
  void test_getPokemonsInfoReturnEmptyData() {
    when(pokemonClient.getPokemonsInfo(null)).thenReturn(getMonoOfEmptyPokemonsDTO());
    StepVerifier.create(pokemonCacheService.getAllPokemonInfo())
        .expectError(OtherException.class)
        .verify();
  }

  @Test
  void test_getPokemonsInfoReturnDataAfterReturnEmptyData() {
    when(pokemonClient.getPokemonsInfo(Mockito.any()))
        .thenReturn(getMonoOfPokemonsDTO())
        .thenReturn(getMonoOfEmptyPokemonsDTO());
    StepVerifier.create(pokemonCacheService.getAllPokemonInfo())
        .expectError(OtherException.class)
        .verify();
  }

  @Test
  void test_getPokemonsInfoReturnDataAfterReturnDataAndCallPokemonInfoReturnException() {
    when(pokemonClient.getPokemonsInfo(Mockito.any()))
        .thenReturn(getMonoOfPokemonsDTO())
        .thenReturn(getMonoOfPokemonsDTO());
    StepVerifier.create(pokemonCacheService.getAllPokemonInfo())
        .expectError(OtherException.class)
        .verify();
  }

  @Test
  void test_getPokemonsInfoReturnDataAfterReturnDataAndCallPokemonInfoReturnData() {
    when(pokemonClient.getPokemonsInfo(Mockito.any()))
        .thenReturn(getMonoOfPokemonsDTO())
        .thenReturn(getMonoOfPokemonsDTO());
    when(pokemonClient.getPokemonInfo(Mockito.any())).thenReturn(getMonoOfPokemonInfoDTO());
    StepVerifier.create(pokemonCacheService.getAllPokemonInfo())
        .expectNextMatches(PokemonUtilities::validatePokemonInfoDtoNotNull)
        .verifyComplete();
  }

}