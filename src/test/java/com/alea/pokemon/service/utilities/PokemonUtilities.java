package com.alea.pokemon.service.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alea.pokemon.service.dto.PokemonInfoDTO;
import com.alea.pokemon.service.dto.PokemonsDTO;
import com.alea.pokemon.service.dto.ResultPokemon;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public class PokemonUtilities {

  public static final String POKEMON_NAME = "pokemon";
  public static final boolean POKEMON_DEFAULT = true;
  public static final Integer POKEMON_ID = 1;
  public static final Integer POKEMON_ORDER = 1;
  public static final Integer POKEMON_HEIGHT = 1;
  public static final Integer POKEMON_WEIGHT = 1;
  public static final Integer POKEMON_BASE_EXPERIENCE = 1;
  public static final String POKEMON_LOCATION_AREA = "location-area";

  public static final Integer POKEMON_COUNT = 1;
  public static final String POKEMON_NEXT = "next";
  public static final String POKEMON_PREVIOUS = "previous";

  public static final String POKEMON_URL = "url";

  public static Mono<PokemonsDTO> getMonoOfEmptyPokemonsDTO() {
    return Mono.just(emptyGetPokemonsDTO());
  }

  public static PokemonsDTO emptyGetPokemonsDTO() {
    PokemonsDTO pokemon = new PokemonsDTO();
    return pokemon;
  }

  public static Mono<PokemonsDTO> getMonoOfPokemonsDTO() {
    return Mono.just(getPokemonsDTO());
  }

  public static PokemonsDTO getPokemonsDTO() {
    PokemonsDTO pokemon = emptyGetPokemonsDTO();
    pokemon.setCount(1);
    pokemon.setResults(getResultPokemonList());
    return pokemon;
  }

  public static List<ResultPokemon> getResultPokemonList() {
    return Collections.singletonList(getResultPokemon());
  }

  private static ResultPokemon getResultPokemon() {
    ResultPokemon resultPokemon = new ResultPokemon();
    resultPokemon.setName(POKEMON_NAME);
    return resultPokemon;
  }

  public static Mono<PokemonInfoDTO> getMonoOfPokemonInfoDTO() {
    return Mono.just(emptyGetPokemonInfoDTO());
  }

  public static PokemonInfoDTO emptyGetPokemonInfoDTO() {
    return new PokemonInfoDTO();
  }

  public static boolean validatePokemonInfoDtoNotNull(PokemonInfoDTO pokemonInfoDTO) {
    return ObjectUtils.allNotNull(pokemonInfoDTO);
  }

  public static boolean validateResponsePokemonInfoDtoNotNull(
      ResponseEntity<List<PokemonInfoDTO>> listResponseEntity) {
    Objects.requireNonNull(listResponseEntity.getBody()).stream()
        .map(PokemonUtilities::validatePokemonInfoDtoNotNull);
    return true;
  }

  public static Mono<List<PokemonInfoDTO>> getMonoOfListPokemonInfoDTO() {
    return Mono.just(getListPokemonInfoDTO());
  }

  public static List<PokemonInfoDTO> getListPokemonInfoDTO() {
    return Collections.singletonList(emptyGetPokemonInfoDTO());
  }

  public static PokemonInfoDTO getPokemonInfoDTOWithData() {
    PokemonInfoDTO pokemon = emptyGetPokemonInfoDTO();
    pokemon.setId(POKEMON_ID);
    pokemon.setName(POKEMON_NAME);
    pokemon.setHeight(POKEMON_HEIGHT);
    pokemon.setWeight(POKEMON_WEIGHT);
    pokemon.setOrder(POKEMON_ORDER);
    pokemon.setDefault(POKEMON_DEFAULT);
    pokemon.setBaseExperience(POKEMON_BASE_EXPERIENCE);
    pokemon.setLocationAreaEncounters(POKEMON_LOCATION_AREA);
    return pokemon;
  }

  public static boolean validateListOfPokemonInfoDtoNotNull(List<PokemonInfoDTO> pokemonInfoDTOS) {
    pokemonInfoDTOS.stream().map(PokemonUtilities::validatePokemonInfoDtoNotNull);
    return true;
  }

  public static boolean validateListOfPokemonHeaviest(List<PokemonInfoDTO> pokemonInfoDTOS) {
    pokemonInfoDTOS.forEach(pokemon ->
        assertEquals(10, (pokemon.getHeight() + pokemon.getOrder()))
    );
    return true;
  }

  public static boolean validateListOfPokemonHighest(List<PokemonInfoDTO> pokemonInfoDTOS) {
    pokemonInfoDTOS.forEach(pokemon ->
        assertEquals(10, (pokemon.getWeight() + pokemon.getOrder()))
    );
    return true;
  }

  public static boolean validateListOfPokemonMoreBaseExperience(
      List<PokemonInfoDTO> pokemonInfoDTOS) {
    pokemonInfoDTOS.forEach(pokemon ->
        assertEquals(10, (pokemon.getBaseExperience() + pokemon.getOrder()))
    );
    return true;
  }

  public static PokemonInfoDTO getPokemonInfo(int index) {
    PokemonInfoDTO pokemon = new PokemonInfoDTO();
    pokemon.setId(index);
    pokemon.setName(POKEMON_NAME + index);
    pokemon.setHeight(index);
    pokemon.setWeight(index);
    pokemon.setOrder(10 - index);
    pokemon.setDefault(true);
    pokemon.setBaseExperience(index);
    pokemon.setLocationAreaEncounters(POKEMON_LOCATION_AREA);

    return pokemon;
  }

  public static PokemonsDTO getListPokemonsWithNames() {
    PokemonsDTO pokemon = new PokemonsDTO();
    pokemon.setCount(10);
    pokemon.setResults(getResultPokemonListWith10Names());
    return pokemon;
  }

  public static List<ResultPokemon> getResultPokemonListWith10Names() {
    return IntStream.range(1, 11).mapToObj(index -> {
      ResultPokemon pokemon = new ResultPokemon();
      pokemon.setName(POKEMON_NAME + index);
      return pokemon;
    }).collect(Collectors.toList());

  }

  public static PokemonsDTO getWiremockResponseCountListPokemon() {
    PokemonsDTO pokemon = new PokemonsDTO();
    pokemon.setCount(10);
    pokemon.setResults(getResultPokemonList());
    return pokemon;
  }

  public static PokemonsDTO getWiremockResponseCountPokemon() {
    PokemonsDTO pokemon = new PokemonsDTO();
    pokemon.setCount(10);
    return pokemon;
  }

  public static PokemonsDTO getWiremockResponseCount20Pokemon() {
    PokemonsDTO pokemon = new PokemonsDTO();
    pokemon.setCount(20);
    return pokemon;
  }


}
