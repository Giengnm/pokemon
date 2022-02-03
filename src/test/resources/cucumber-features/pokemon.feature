Feature: This is a module feature

  Scenario: client makes call to GET /api/v1/pokemon/heaviest and return Server Error
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 without body
    When the client calls "/api/v1/pokemon/heaviest" with "response-0"
    Then the client receives response "response-0" status code of 500
    Then close wiremock server

  Scenario: client makes call to GET /api/v1/pokemon/highest and return Server Error
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 without body
    When the client calls "/api/v1/pokemon/highest" with "response-1"
    Then the client receives response "response-1" status code of 500
    Then close wiremock server

  Scenario: client makes call to GET /api/v1/pokemon/more-base-experience and return Server Error
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 without body
    When the client calls "/api/v1/pokemon/more-base-experience" with "response-2"
    Then the client receives response "response-2" status code of 500
    Then close wiremock server

  Scenario: Clear stubs
    Given clear the stubs on wiremock server

  Scenario: client makes call to GET /api/v1/pokemon/heaviest and return Conflict
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 with body response "count-pokemons"
    When the server call to wiremock GET "/pokemon?limit=10", return 200 with body response "count-list-pokemons"
    When the server call to wiremock GET "/pokemon/pokemon", return 200 with body response "data-pokemon"
    When the client calls "/api/v1/pokemon/heaviest" with "response-4"
    Then the client receives response "response-4" status code of 409
    Then the client receives response "response-4" message contains "Not found pokemons with weight"
    Then close wiremock server

  Scenario: client makes call to GET /api/v1/pokemon/highest and return Conflict
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 with body response "count-pokemons"
    When the server call to wiremock GET "/pokemon?limit=10", return 200 with body response "count-list-pokemons"
    When the server call to wiremock GET "/pokemon/pokemon", return 200 with body response "data-pokemon"
    When the client calls "/api/v1/pokemon/highest" with "response-5"
    Then the client receives response "response-5" status code of 409
    Then the client receives response "response-5" message contains "Not found pokemons with height"
    Then close wiremock server

  Scenario: client makes call to GET /api/v1/pokemon/more-base-experience and return Conflict
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 with body response "count-pokemons"
    When the server call to wiremock GET "/pokemon?limit=10", return 200 with body response "count-list-pokemons"
    When the server call to wiremock GET "/pokemon/pokemon", return 200 with body response "data-pokemon"
    When the client calls "/api/v1/pokemon/more-base-experience" with "response-6"
    Then the client receives response "response-6" status code of 409
    Then the client receives response "response-6" message contains "Not found pokemons with base experience"
    Then close wiremock server

  Scenario: Clear stubs
    Given clear the stubs on wiremock server

  Scenario: client makes a call to GET /api/v1/pokemon/heaviest, returns Success and the five heaviest pokemons
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 with body response "count-pokemons-20"
    When the server call to wiremock GET "/pokemon?limit=20", return 200 with body response "count-list-pokemons-with-names"
    When the server call to wiremock GET "/pokemon/pokemon1", return 200 with body response "data-pokemon-1"
    When the server call to wiremock GET "/pokemon/pokemon2", return 200 with body response "data-pokemon-2"
    When the server call to wiremock GET "/pokemon/pokemon3", return 200 with body response "data-pokemon-3"
    When the server call to wiremock GET "/pokemon/pokemon4", return 200 with body response "data-pokemon-4"
    When the server call to wiremock GET "/pokemon/pokemon5", return 200 with body response "data-pokemon-5"
    When the server call to wiremock GET "/pokemon/pokemon6", return 200 with body response "data-pokemon-6"
    When the server call to wiremock GET "/pokemon/pokemon7", return 200 with body response "data-pokemon-7"
    When the server call to wiremock GET "/pokemon/pokemon8", return 200 with body response "data-pokemon-8"
    When the server call to wiremock GET "/pokemon/pokemon9", return 200 with body response "data-pokemon-9"
    When the server call to wiremock GET "/pokemon/pokemon10", return 200 with body response "data-pokemon-10"
    When the client calls "/api/v1/pokemon/heaviest" with "response-0"
    Then the client receives response "response-0" status code of 200
    Then the client receives response "response-0" check weight
    Then close wiremock server

  Scenario: client makes a call to GET /api/v1/pokemon/highest, returns Success and the five highest pokemons
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 with body response "count-pokemons-20"
    When the server call to wiremock GET "/pokemon?limit=20", return 200 with body response "count-list-pokemons-with-names"
    When the server call to wiremock GET "/pokemon/pokemon1", return 200 with body response "data-pokemon-1"
    When the server call to wiremock GET "/pokemon/pokemon2", return 200 with body response "data-pokemon-2"
    When the server call to wiremock GET "/pokemon/pokemon3", return 200 with body response "data-pokemon-3"
    When the server call to wiremock GET "/pokemon/pokemon4", return 200 with body response "data-pokemon-4"
    When the server call to wiremock GET "/pokemon/pokemon5", return 200 with body response "data-pokemon-5"
    When the server call to wiremock GET "/pokemon/pokemon6", return 200 with body response "data-pokemon-6"
    When the server call to wiremock GET "/pokemon/pokemon7", return 200 with body response "data-pokemon-7"
    When the server call to wiremock GET "/pokemon/pokemon8", return 200 with body response "data-pokemon-8"
    When the server call to wiremock GET "/pokemon/pokemon9", return 200 with body response "data-pokemon-9"
    When the server call to wiremock GET "/pokemon/pokemon10", return 200 with body response "data-pokemon-10"
    When the client calls "/api/v1/pokemon/highest" with "response-1"
    Then the client receives response "response-1" status code of 200
    Then the client receives response "response-1" check height
    Then close wiremock server

  Scenario: client makes a call to GET /api/v1/pokemon/more-base-experience, returns Success and the five most base experience pokemons
    Given start wiremock server
    When the server call to wiremock GET "/pokemon", return 200 with body response "count-pokemons-20"
    When the server call to wiremock GET "/pokemon?limit=20", return 200 with body response "count-list-pokemons-with-names"
    When the server call to wiremock GET "/pokemon/pokemon1", return 200 with body response "data-pokemon-1"
    When the server call to wiremock GET "/pokemon/pokemon2", return 200 with body response "data-pokemon-2"
    When the server call to wiremock GET "/pokemon/pokemon3", return 200 with body response "data-pokemon-3"
    When the server call to wiremock GET "/pokemon/pokemon4", return 200 with body response "data-pokemon-4"
    When the server call to wiremock GET "/pokemon/pokemon5", return 200 with body response "data-pokemon-5"
    When the server call to wiremock GET "/pokemon/pokemon6", return 200 with body response "data-pokemon-6"
    When the server call to wiremock GET "/pokemon/pokemon7", return 200 with body response "data-pokemon-7"
    When the server call to wiremock GET "/pokemon/pokemon8", return 200 with body response "data-pokemon-8"
    When the server call to wiremock GET "/pokemon/pokemon9", return 200 with body response "data-pokemon-9"
    When the server call to wiremock GET "/pokemon/pokemon10", return 200 with body response "data-pokemon-10"
    When the client calls "/api/v1/pokemon/more-base-experience" with "response-2"
    Then the client receives response "response-2" status code of 200
    Then the client receives response "response-2" check more base experience
    Then close wiremock server