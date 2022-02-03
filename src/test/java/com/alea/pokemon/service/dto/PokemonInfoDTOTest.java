package com.alea.pokemon.service.dto;

import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_BASE_EXPERIENCE;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_DEFAULT;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_HEIGHT;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_ID;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_LOCATION_AREA;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_NAME;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_ORDER;
import static com.alea.pokemon.service.utilities.PokemonUtilities.POKEMON_WEIGHT;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PokemonInfoDTOTest {

  @Test
  void test() {
    PokemonInfoDTO pokemon = null;

    assertNull(pokemon);

    pokemon = new PokemonInfoDTO();

    assertNotNull(pokemon);
    assertNull(pokemon.getName(), "The name is not null");

    pokemon.setName(POKEMON_NAME);

    assertNotNull(pokemon.getName(), "The name is null");
    assertFalse(pokemon.isDefault(), "The default is not null");

    pokemon.setDefault(POKEMON_DEFAULT);

    assertTrue(pokemon.isDefault(), "The default is false");
    assertNull(pokemon.getId(), "The id is not null");

    pokemon.setId(POKEMON_ID);

    assertNotNull(pokemon.getId(), "The id is null");
    assertNull(pokemon.getOrder(), "The order is not null");

    pokemon.setOrder(POKEMON_ORDER);

    assertNotNull(pokemon.getOrder(), "The order is null");
    assertNull(pokemon.getHeight(), "The height is not null");

    pokemon.setHeight(POKEMON_HEIGHT);

    assertNotNull(pokemon.getHeight(), "The height is null");
    assertNull(pokemon.getWeight(), "The weight is not null");

    pokemon.setWeight(POKEMON_WEIGHT);

    assertNotNull(pokemon.getWeight(), "The weight is null");
    assertNull(pokemon.getBaseExperience(), "The base experience is not null");

    pokemon.setBaseExperience(POKEMON_BASE_EXPERIENCE);

    assertNotNull(pokemon.getBaseExperience(), "The base experience is null");
    assertNull(pokemon.getLocationAreaEncounters(), "The location area is not null");

    pokemon.setLocationAreaEncounters(POKEMON_LOCATION_AREA);

    assertNotNull(pokemon.getLocationAreaEncounters(), "The location area is null");


  }

}