package com.alea.pokemon.cucumber;

import com.alea.pokemon.PokemonApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@CucumberContextConfiguration
@SpringBootTest(classes = {PokemonApplication.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = PokemonApplication.class, loader = SpringBootContextLoader.class)
@Slf4j
public class AbstractDefinitions {

  @Before
  public void setUp() {
    log.info("**********Cucumber started **********");
  }
  
}
