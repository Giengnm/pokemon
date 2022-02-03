package com.alea.pokemon.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Pokemons", description = "The pokemon information")
public class PokemonInfoDTO implements Serializable {

  @Schema(description = "The pokemon unique id.",
      example = "1",
      type = "integer")
  @JsonProperty("id")
  private Integer id;

  @Schema(description = "The pokemon name",
      example = "Picachu",
      type = "string")
  @JsonProperty("name")
  private String name;

  @Schema(description = "The pokemon base experience.",
      example = "0",
      type = "integer")
  @JsonProperty("base_experience")
  private Integer baseExperience;

  @Schema(description = "The pokemon height.",
      example = "10",
      type = "integer")
  @JsonProperty("height")
  private Integer height;

  @Schema(description = "The pokemon is default.",
      example = "1",
      type = "integer")
  @JsonProperty("is_default")
  private boolean isDefault;

  @Schema(description = "The pokemon order.",
      example = "1",
      type = "integer")
  @JsonProperty("order")
  private Integer order;

  @Schema(description = "The pokemon weight.",
      example = "1",
      type = "integer")
  @JsonProperty("weight")
  private Integer weight;

  @Schema(description = "The pokemon location area encounters id.",
      example = "1",
      type = "integer")
  @JsonProperty("location_area_encounters")
  private String locationAreaEncounters;
}
