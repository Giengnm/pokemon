package com.alea.pokemon.service.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultPokemon implements Serializable {

  private String name;
  private String url;
}
