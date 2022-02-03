package com.alea.pokemon.api.impl;

import static com.alea.pokemon.common.exception.CodeException.ERR_0002;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getMonoOfListPokemonInfoDTO;
import static org.mockito.Mockito.when;

import com.alea.pokemon.api.exception.NotFoundException;
import com.alea.pokemon.service.PokemonService;
import com.alea.pokemon.service.exception.ServerException;
import com.alea.pokemon.service.utilities.PokemonUtilities;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class PokemonControllerImplTest {

  @Mock
  private PokemonService pokemonService;

  @InjectMocks
  private PokemonControllerImpl pokemonController;

  @Test
  void test_getPokemonHeaviestReturnError() {
    prepareError(pokemonService.getPokemonHeaviest());

    StepVerifier
        .create(pokemonController.getPokemonHeaviest())
        .expectError()
        .verify();
  }

  @Test
  void test_getPokemonHeaviestReturnNotFoundData() {
    prepareNotFoundData(pokemonService.getPokemonHeaviest());

    StepVerifier
        .create(pokemonController.getPokemonHeaviest())
        .expectError(NotFoundException.class)
        .verify();
  }

  @Test
  void test_getPokemonHeaviestReturnData() {
    prepareData(pokemonService.getPokemonHeaviest());

    StepVerifier
        .create(pokemonController.getPokemonHeaviest())
        .expectNextMatches(PokemonUtilities::validateResponsePokemonInfoDtoNotNull)
        .verifyComplete();
  }

  @Test
  void test_getPokemonHighestReturnError() {
    prepareError(pokemonService.getPokemonHighest());

    StepVerifier
        .create(pokemonController.getPokemonHighest())
        .expectError()
        .verify();
  }

  @Test
  void test_getPokemonHighestReturnNotFoundData() {
    prepareNotFoundData(pokemonService.getPokemonHighest());

    StepVerifier
        .create(pokemonController.getPokemonHighest())
        .expectError(NotFoundException.class)
        .verify();
  }

  @Test
  void test_getPokemonHighestReturnData() {
    prepareData(pokemonService.getPokemonHighest());

    StepVerifier
        .create(pokemonController.getPokemonHighest())
        .expectNextMatches(PokemonUtilities::validateResponsePokemonInfoDtoNotNull)
        .verifyComplete();
  }

  @Test
  void test_getPokemonMoreBaseExperienceReturnError() {
    prepareError(pokemonService.getPokemonMoreBaseExperience());

    StepVerifier
        .create(pokemonController.getPokemonMoreBaseExperience())
        .expectError()
        .verify();
  }

  @Test
  void test_getPokemonMoreBaseExperienceReturnNotFoundData() {
    prepareNotFoundData(pokemonService.getPokemonMoreBaseExperience());

    StepVerifier
        .create(pokemonController.getPokemonMoreBaseExperience())
        .expectError(NotFoundException.class)
        .verify();
  }

  @Test
  void test_getPokemonMoreBaseExperienceReturnData() {
    prepareData(pokemonService.getPokemonMoreBaseExperience());

    StepVerifier
        .create(pokemonController.getPokemonMoreBaseExperience())
        .expectNextMatches(PokemonUtilities::validateResponsePokemonInfoDtoNotNull)
        .verifyComplete();
  }

  private void prepareError(Object method) {
    when(method)
        .thenReturn(Mono.error(new ServerException(ERR_0002)));
  }

  private void prepareNotFoundData(Object method) {
    when(method)
        .thenReturn(Mono.empty());
  }

  private void prepareData(Object method) {
    when(method)
        .thenReturn(getMonoOfListPokemonInfoDTO());
  }
}