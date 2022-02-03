package com.alea.pokemon.common.exception;

import lombok.Getter;

@Getter
public enum CodeException {

  ERR_0001("Pokemon Not Found"),
  ERR_0002("Error to call pokemon api"),
  ERR_0003("Not found pokemons with weight"),
  ERR_0004("Not found pokemons with height"),
  ERR_0005("Not found pokemons with base experience");

  private final String description;

  CodeException(String description) {
    this.description = description;
  }

  public String getCode() {
    return this.name().replace("_", "-");
  }
}
