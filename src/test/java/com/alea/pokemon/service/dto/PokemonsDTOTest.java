package com.alea.pokemon.service.dto;

import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_COUNT;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_NEXT;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_PREVIOUS;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getResultPokemonList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class PokemonsDTOTest {

  @Test
  void test() {
    PokemonsDTO pokemons = null;

    assertNull(pokemons);

    pokemons = new PokemonsDTO();

    assertNotNull(pokemons);
    assertNull(pokemons.getCount(), "The count is not null");
    assertNull(pokemons.getNext(), "The next is not null");
    assertNull(pokemons.getPrevious(), "The previous is not null");
    assertNull(pokemons.getResults(), "The result is not null");

    pokemons.setCount(POKEMON_COUNT);
    pokemons.setNext(POKEMON_NEXT);
    pokemons.setPrevious(POKEMON_PREVIOUS);
    pokemons.setResults(getResultPokemonList());

    assertNotNull(pokemons.getCount(), "The count is null");
    assertNotNull(pokemons.getNext(), "The next is null");
    assertNotNull(pokemons.getPrevious(), "The previous is null");
    assertNotNull(pokemons.getResults(), "The result is null");
  }

}