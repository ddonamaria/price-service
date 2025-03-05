package com.company.priceservice.teste2e;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceServiceE2ETest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void Test_1() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("\"priceId\":1"));
    }

    @Test
    public void Test_2() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("\"priceId\":2"));
    }

    @Test
    public void Test_3() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("\"priceId\":1"));
    }

    @Test
    public void Test_4() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("\"priceId\":3"));
    }

    @Test
    public void Test_5() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=2020-06-16T21:00:00&productId=35455&brandId=1", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).contains("\"priceId\":4"));
    }

    @Test
    public void test_priceNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=2020-06-13T00:00:00&productId=35455&brandId=1", String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertTrue(response.getBody().contains("\"message\":\"No price found"));
    }

    @Test
    public void test_allParametersNull_invalidParameterException() {
        ResponseEntity<String> response = restTemplate.getForEntity("/price?applicationDate=&productId=&brandId=", String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}
