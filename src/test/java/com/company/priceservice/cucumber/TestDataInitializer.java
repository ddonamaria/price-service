package com.company.priceservice.cucumber;

import com.company.priceservice.domain.valueobjects.CurrencyCode;
import com.company.priceservice.infrastructure.adapters.repositories.JpaPriceRepository;
import com.company.priceservice.infrastructure.adapters.repositories.entities.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@TestConfiguration
class TestDataInitializer {
    private final JpaPriceRepository jpaPriceRepository;

    @Autowired
    TestDataInitializer(JpaPriceRepository jpaPriceRepository) {
        this.jpaPriceRepository = jpaPriceRepository;
    }

    @EventListener(ApplicationStartedEvent.class)
    @Transactional
    public void initialize() {
        jpaPriceRepository.deleteAll();
        jpaPriceRepository.saveAll(getPriceEntityList());
    }

    private List<PriceEntity> getPriceEntityList() {
        return List.of(
                new PriceEntity(1,
                        35455L,
                        1,
                        0,
                        LocalDateTime.of(2020, 6, 14, 0, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                        new BigDecimal("35.50"),
                        CurrencyCode.EUR),

                new PriceEntity(2,
                        35455L,
                        1,
                        1,
                        LocalDateTime.of(2020, 6, 14, 15, 0, 0),
                        LocalDateTime.of(2020, 6, 14, 18, 30, 0),
                        new BigDecimal("25.45"),
                        CurrencyCode.EUR),

                new PriceEntity(3,
                        35455L,
                        1,
                        1,
                        LocalDateTime.of(2020, 6, 15, 0, 0, 0),
                        LocalDateTime.of(2020, 6, 15, 11, 0, 0),
                        new BigDecimal("30.50"),
                        CurrencyCode.EUR),

                new PriceEntity(4,
                        35455L,
                        1,
                        1,
                        LocalDateTime.of(2020, 6, 15, 16, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59, 59),
                        new BigDecimal("38.95"),
                        CurrencyCode.EUR)
        );
    }

}