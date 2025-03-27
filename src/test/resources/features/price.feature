Feature: Consulta de precios en la API

  # Functional tests

  Scenario: Successfully retrieve product price
    Given the system has available price data
    When the price with date "2020-06-14T00:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 1
    And the found price should be "35.50"

  Scenario: Obtain the highest priority price when there are matches
    Given the system has available price data
    When the price with date "2020-06-14T15:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 2
    And the found price should be "25.45"

  Scenario: Product not found
    When the price with date "2020-06-14T16:00:00" for product "99999" and brand "1" is queried
    Then the response should have http status code 404

  # Proposed tests

  Scenario: Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    Given the system has available price data
    When the price with date "2020-06-14T10:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 1
    And the found price should be "35.50"

  Scenario: Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    Given the system has available price data
    When the price with date "2020-06-14T16:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 2
    And the found price should be "25.45"

  Scenario: Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    Given the system has available price data
    When the price with date "2020-06-14T21:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 1
    And the found price should be "35.50"

  Scenario: Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    Given the system has available price data
    When the price with date "2020-06-15T10:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 3
    And the found price should be "30.50"

  Scenario: Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    Given the system has available price data
    When the price with date "2020-06-16T21:00:00" for product "35455" and brand "1" is queried
    Then the response should have http status code 200
    And the found price id should be 4
    And the found price should be "38.95"