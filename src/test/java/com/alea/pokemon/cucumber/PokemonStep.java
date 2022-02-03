package com.alea.pokemon.cucumber;

import static com.alea.pokemon.service.utilities.PokemonUtilities.emptyGetPokemonInfoDTO;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getListPokemonsWithNames;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getPokemonInfo;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getWiremockResponseCount20Pokemon;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getWiremockResponseCountListPokemon;
import static com.alea.pokemon.service.utilities.PokemonUtilities.getWiremockResponseCountPokemon;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.alea.pokemon.service.dto.PokemonInfoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PokemonStep {

  @Autowired
  protected TestRestTemplate template;

  protected WireMockServer wireMockServer = new WireMockServer(8082);
  protected static ObjectMapper objectMapper = new ObjectMapper();

  private Map<String, ResponseEntity> responses = new HashMap<>();

  static Map<String, Object> responseMap = new HashMap<>();

  private List<StubMapping> stubMappings = new ArrayList<>();

  static {
    responseMap.put("count-pokemons", getWiremockResponseCountPokemon());
    responseMap.put("count-list-pokemons", getWiremockResponseCountListPokemon());
    responseMap.put("data-pokemon", emptyGetPokemonInfoDTO());
    responseMap.put("count-pokemons-20", getWiremockResponseCount20Pokemon());
    responseMap.put("count-list-pokemons-with-names", getListPokemonsWithNames());
    responseMap.put("data-pokemon-1", getPokemonInfo(1));
    responseMap.put("data-pokemon-2", getPokemonInfo(2));
    responseMap.put("data-pokemon-3", getPokemonInfo(3));
    responseMap.put("data-pokemon-4", getPokemonInfo(4));
    responseMap.put("data-pokemon-5", getPokemonInfo(5));
    responseMap.put("data-pokemon-6", getPokemonInfo(6));
    responseMap.put("data-pokemon-7", getPokemonInfo(7));
    responseMap.put("data-pokemon-8", getPokemonInfo(8));
    responseMap.put("data-pokemon-9", getPokemonInfo(9));
    responseMap.put("data-pokemon-10", getPokemonInfo(10));
  }

  @Given("start wiremock server")
  public void startWiremockServer() {
    this.wireMockServer.start();
  }

  @Then("close wiremock server")
  public void closeWiremockServer() {
    this.wireMockServer.stop();
  }

  @When("the server call to wiremock GET {string}, return {int} with body response {string}")
  public void theServerCallToWiremockGETReturnWithBodyResponse(
      final String path, final int status, final String body) throws JsonProcessingException {

    stubMappings.add(wireMockServer.stubFor(get(urlEqualTo(path))
        .willReturn(aResponse()
            .withStatus(status)
            .withHeader("Content-Type", "application/json;charset=UTF-8")
            .withBody(objectMapper.writeValueAsString(responseMap.get(body))))));
  }

  @When("the server call to wiremock GET {string}, return {int} without body")
  public void theServerCallToWiremockGETReturnWithoutBody(final String path, final int status) {
    stubMappings.add(wireMockServer.stubFor(get(urlEqualTo(path))
        .willReturn(aResponse()
            .withStatus(status)
            .withHeader("Content-Type", "application/json;charset=UTF-8")
            .withBody("{}"))));
  }

  @When("the client calls {string} with {string}")
  public void theClientCalls(String path, String response) {
    responses.put(response, template.getForEntity(path, Object.class));
  }

  @When("the client calls {string} with {string} to List")
  public void theClientCallsToList(String path, String response) {
    responses.put(response,
        template.getForEntity(path, PokemonInfoDTO[].class));
  }

  @Then("the client receives response {string} status code of {int}")
  public void theClientReceivesResponseStatusCodeOf(String response, int statusCode) {
    HttpStatus currentStatusCode = responses.get(response).getStatusCode();
    assertThat("status code is incorrect : " +
        responses.get(response).getBody(), currentStatusCode.value(), is(statusCode));
  }

  @Then("the client receives response {string} message contains {string}")
  public void theClientReceivesResponseMessage(String response, String message) {
    assertTrue(responses.get(response).getBody().toString().contains(message));
  }

  @Then("the client receives response {string} check more base experience")
  public void theClientReceivesResponseCheckMoreBaseExperience(String response)
      throws JsonProcessingException {
    List<PokemonInfoDTO> pokemons = convertToPokemonInfoDTO(response);

    pokemons.forEach(pokemon -> {
      assertEquals(10 - pokemon.getOrder(), pokemon.getBaseExperience());
    });

  }

  @Then("the client receives response {string} check height")
  public void theClientReceivesResponseCheckHeight(String response)
      throws JsonProcessingException {
    List<PokemonInfoDTO> pokemons = convertToPokemonInfoDTO(response);

    pokemons.forEach(pokemon -> {
      assertEquals(10 - pokemon.getOrder(), pokemon.getHeight());
    });

  }

  @Then("the client receives response {string} check weight")
  public void theClientReceivesResponseCheckWeight(String response)
      throws JsonProcessingException {
    List<PokemonInfoDTO> pokemons = convertToPokemonInfoDTO(response);

    pokemons.forEach(pokemon -> {
      assertEquals(10 - pokemon.getOrder(), pokemon.getWeight());
    });

  }

  @Given("clear the stubs on wiremock server")
  public void clearTheStubsOnWiremockServer() {
    stubMappings.forEach(stubMapping -> wireMockServer.removeStub(stubMapping));
  }

  private List<PokemonInfoDTO> convertToPokemonInfoDTO(String response)
      throws JsonProcessingException {
    return objectMapper.readValue(
        objectMapper.writeValueAsString(responses.get(response).getBody()),
        new TypeReference<List<PokemonInfoDTO>>() {
        });
  }
}
