package com.alea.pokemon.api;

import static com.alea.pokemon.common.Constants.API_VERSION;
import static com.alea.pokemon.common.Constants.RESPONSE_CODE_CONFLICT;
import static com.alea.pokemon.common.Constants.RESPONSE_CODE_FORBIDDEN;
import static com.alea.pokemon.common.Constants.RESPONSE_CODE_INTERNAL_SERVER_ERROR;
import static com.alea.pokemon.common.Constants.RESPONSE_CODE_OK;
import static com.alea.pokemon.common.Constants.RESPONSE_CODE_UNAUTHORIZED;
import static com.alea.pokemon.common.Constants.RESPONSE_DESCRIPTION_CONFLICT;
import static com.alea.pokemon.common.Constants.RESPONSE_DESCRIPTION_FORBIDDEN;
import static com.alea.pokemon.common.Constants.RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR;
import static com.alea.pokemon.common.Constants.RESPONSE_DESCRIPTION_OK;
import static com.alea.pokemon.common.Constants.RESPONSE_DESCRIPTION_UNAUTHORIZED;

import com.alea.pokemon.service.dto.PokemonInfoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@RequestMapping(API_VERSION + "/pokemon")
@Tag(name = "pokemons", description = "the pokemon API")
public interface PokemonController {

  String TAG = "pokemon";

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "heaviest")
  @Operation(summary = "The 5 heaviest Pokémons",
      description = "Query for get the top five heaviest pokemon.",
      tags = {TAG})
  @ApiResponses(value = {
      @ApiResponse(responseCode = RESPONSE_CODE_OK,
          description = RESPONSE_DESCRIPTION_OK,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              schema = @Schema(implementation = PokemonInfoDTO.class)
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_UNAUTHORIZED,
          description = RESPONSE_DESCRIPTION_UNAUTHORIZED,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_UNAUTHORIZED + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_UNAUTHORIZED + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_FORBIDDEN,
          description = RESPONSE_DESCRIPTION_FORBIDDEN,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_FORBIDDEN + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_FORBIDDEN + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_CONFLICT,
          description = RESPONSE_DESCRIPTION_CONFLICT,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_CONFLICT + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_CONFLICT + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_INTERNAL_SERVER_ERROR,
          description = RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_INTERNAL_SERVER_ERROR + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      )
  })
  Mono<ResponseEntity<List<PokemonInfoDTO>>> getPokemonHeaviest();

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "highest")
  @Operation(summary = "The 5 highest Pokémons.",
      description = "Query for get the top five highest pokemon.",
      tags = {TAG})
  @ApiResponses(value = {
      @ApiResponse(responseCode = RESPONSE_CODE_OK,
          description = RESPONSE_DESCRIPTION_OK,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              array = @ArraySchema(
                  schema = @Schema(implementation = PokemonInfoDTO.class)
              )
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_UNAUTHORIZED,
          description = RESPONSE_DESCRIPTION_UNAUTHORIZED,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_UNAUTHORIZED + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_UNAUTHORIZED + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_FORBIDDEN,
          description = RESPONSE_DESCRIPTION_FORBIDDEN,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_FORBIDDEN + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_FORBIDDEN + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_CONFLICT,
          description = RESPONSE_DESCRIPTION_CONFLICT,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_CONFLICT + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_CONFLICT + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_INTERNAL_SERVER_ERROR,
          description = RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_INTERNAL_SERVER_ERROR + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      )
  })
  Mono<ResponseEntity<List<PokemonInfoDTO>>> getPokemonHighest();

  @GetMapping(value = "/more-base-experience",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "The 5 Pokémons with more base experience.",
      description = "Query for get the top five pokemon with most base experience",
      tags = {TAG})
  @ApiResponses(value = {
      @ApiResponse(responseCode = RESPONSE_CODE_OK,
          description = RESPONSE_DESCRIPTION_OK,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              array = @ArraySchema(
                  schema = @Schema(implementation = PokemonInfoDTO.class)
              )
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_UNAUTHORIZED,
          description = RESPONSE_DESCRIPTION_UNAUTHORIZED,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_UNAUTHORIZED + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_UNAUTHORIZED + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_FORBIDDEN,
          description = RESPONSE_DESCRIPTION_FORBIDDEN,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_FORBIDDEN + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_FORBIDDEN + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_CONFLICT,
          description = RESPONSE_DESCRIPTION_CONFLICT,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_CONFLICT + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_CONFLICT + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      ),
      @ApiResponse(responseCode = RESPONSE_CODE_INTERNAL_SERVER_ERROR,
          description = RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR,
          content = @Content(
              mediaType = MediaType.APPLICATION_JSON_VALUE,
              examples = @ExampleObject(value = "{\n" +
                  "  \"timestamp\": \"2021-01-13T11:48:01.590+00:00\",\n" +
                  "  \"exception\": \"ExampleException\",\n" +
                  "  \"requestId\": \"5406f7f1-1\",\n" +
                  "  \"status\": \"" + RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR + "\",\n" +
                  "  \"error\": " + RESPONSE_CODE_INTERNAL_SERVER_ERROR + ",\n" +
                  "  \"message\": \"My example exception!!\"\n" +
                  "}")
          )
      )
  })
  Mono<ResponseEntity<List<PokemonInfoDTO>>> getPokemonMoreBaseExperience();

}
