package com.company.priceservice.cucumber.steps;

import com.company.priceservice.infrastructure.adapters.api.models.PriceDTO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

public class PriceSteps {

    private static final Logger log = LoggerFactory.getLogger(PriceSteps.class);

    private RestClient restClient;
    private ResponseEntity<PriceDTO> response;

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:" + port)
                .build();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Given("the system has available price data")
    public void the_system_has_available_price_data() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT COUNT(*) as count FROM PRICE");
        int count = Integer.parseInt(rows.getFirst().get("count").toString());
        log.info("Number of records in PRICE table: {}", count);
        Assertions.assertTrue(count > 0, "No data found in PRICE table");
    }

    @When("the price with date {string} for product {string} and brand {string} is queried")
    public void the_price_with_params_is_queried(String date, String productId, String brandId) {
        log.info("Querying price: date={}, productId={}, brandId={}", date, productId, brandId);

        response = restClient.get()
                .uri("/price?applicationDate={date}&productId={productId}&brandId={brandId}",
                        date, productId, brandId)
                .exchange((request, resp) -> {
                    // Error
                    if (resp.getStatusCode().is4xxClientError()) {
                        return ResponseEntity.status(resp.getStatusCode()).build();
                    }
                    // Success
                    return ResponseEntity.status(resp.getStatusCode())
                            .body(resp.bodyTo(PriceDTO.class));
                });

        log.info("Response: status={}, body={}", response.getStatusCode(), response.getBody());
    }

    @Then("the response should have http status code {int}")
    public void the_response_should_have_http_status_code(int expectedStatusCode) {
        HttpStatus expectedStatus = HttpStatus.valueOf(expectedStatusCode);
        Assertions.assertEquals(expectedStatus, response.getStatusCode(),
                "Expected http status code was " + expectedStatus + " but received " + response.getStatusCode());
    }

    @Then("the found price should be {string}")
    public void the_found_price_should_be(String expectedPrice) {
        String foundPrice = response.getBody().getPrice().toString();
        Assertions.assertEquals(expectedPrice, foundPrice,
                "Expected price was " + expectedPrice + " but received " + foundPrice);
    }

    @Then("the found price id should be {int}")
    public void the_found_price_id_should_be(int expectedPriceId) {
        int foundPriceId = response.getBody().getPriceId();
        Assertions.assertEquals(expectedPriceId, foundPriceId,
                "Expected price was " + expectedPriceId + " but received " + foundPriceId);
    }

}
