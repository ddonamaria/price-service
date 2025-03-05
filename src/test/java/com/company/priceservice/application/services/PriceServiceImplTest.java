package com.company.priceservice.application.services;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.application.mappers.PriceMapper;
import com.company.priceservice.domain.models.Price;
import com.company.priceservice.infrastructure.adapters.repositories.JpaPriceRepository;
import com.company.priceservice.infrastructure.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private JpaPriceRepository priceRepository;

    @Mock
    private PriceMapper priceMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void findPriceByParams() {
        Optional<Price> optionalPrice = Optional.of(new Price());
        when(priceRepository.findPriceByParams(35455L, 1, LocalDateTime.parse("2025-03-05T21:00:00"))).thenReturn(optionalPrice);
        when(priceMapper.entityToDto(optionalPrice.get())).thenReturn(new PriceDTO());

        PriceDTO result = priceService.findPriceByParams(LocalDateTime.parse("2025-03-05T21:00:00"), 35455L, 1);

        assertNotNull(result);
        assertInstanceOf(PriceDTO.class, result);
    }

    @Test
    void findPriceByParams_ThrowsPriceNotFoundException() {
        when(priceRepository.findPriceByParams(35455L, 1, LocalDateTime.parse("2025-03-05T21:00:00"))).thenReturn(Optional.empty());

        assertThrows(
                PriceNotFoundException.class,
                () -> priceService.findPriceByParams(LocalDateTime.parse("2025-03-05T21:00:00"), 35455L, 1)
        );

    }
}