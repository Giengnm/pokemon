package com.alea.pokemon.service.dto;

import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_NAME;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_URL;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ResultPokemonTest {

  @Test
  void test() {
    ResultPokemon pokemon = null;

    assertNull(pokemon);

    pokemon = new ResultPokemon();

    assertNotNull(pokemon);
    assertNull(pokemon.getName(), "The name is not null");
    assertNull(pokemon.getUrl(), "The url is not null");

    pokemon.setName(POKEMON_NAME);
    pokemon.setUrl(POKEMON_URL);

    assertNotNull(pokemon.getName(), "The name is null");
    assertNotNull(pokemon.getUrl(), "The url is null");
  }

}