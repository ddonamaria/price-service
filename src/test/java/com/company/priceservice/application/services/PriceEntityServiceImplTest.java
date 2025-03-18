package com.company.priceservice.application.services;

import com.company.priceservice.application.PriceServiceImpl;
import com.company.priceservice.domain.models.Price;
import com.company.priceservice.infrastructure.adapters.api.exceptions.PriceNotFoundException;
import com.company.priceservice.infrastructure.adapters.repositories.JpaPriceRepository;
import com.company.priceservice.infrastructure.adapters.repositories.entities.PriceEntity;
import com.company.priceservice.infrastructure.adapters.repositories.mappers.PriceEntityMapper;
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
    private PriceEntityMapper priceEntityMapper;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void findPriceByParams() {
        Optional<PriceEntity> optionalPrice = Optional.of(new PriceEntity());
        when(priceRepository.findPriceByParams(35455L, 1, LocalDateTime.parse("2025-03-05T21:00:00"))).thenReturn(optionalPrice);
        when(priceEntityMapper.entityToPrice(optionalPrice.get())).thenReturn(new Price());

        Price result = priceService.findPriceByParams(LocalDateTime.parse("2025-03-05T21:00:00"), 35455L, 1);

        assertNotNull(result);
        assertInstanceOf(Price.class, result);
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