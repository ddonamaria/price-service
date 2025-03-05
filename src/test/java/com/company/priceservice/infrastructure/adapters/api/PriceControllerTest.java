package com.company.priceservice.infrastructure.adapters.api;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.application.ports.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    @Test
    void findPriceByParams() {
        when(priceService.findPriceByParams(LocalDateTime.parse("2025-03-05T21:00:00"), 35455L, 1)).thenReturn(new PriceDTO());
        var result = priceController.findPriceByParams(LocalDateTime.parse("2025-03-05T21:00:00"), 35455L, 1);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
    }

}