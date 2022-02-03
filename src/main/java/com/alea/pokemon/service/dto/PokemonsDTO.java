package com.alea.pokemon.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonsDTO implements Serializable {

  private Integer count;
  private String next;
  private String previous;

  @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
  private List<ResultPokemon> results;
}
