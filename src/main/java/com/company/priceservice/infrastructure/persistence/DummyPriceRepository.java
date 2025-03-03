package com.company.priceservice.infrastructure.persistence;

import com.company.priceservice.domain.model.Price;
import com.company.priceservice.domain.repository.PriceRepository;
import com.company.priceservice.domain.valueobjects.CurrencyCode;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DummyPriceRepository  implements PriceRepository {

    @Override
    public List<Price> findPrices(LocalDateTime applicationDate, Long productId, Integer brandId) {
        return getPrices();
    }

    private List<Price> getPrices() {
        List<Price> priceList = new ArrayList<>();
        priceList.add(new Price(1, 35455L, 1, 0, LocalDateTime.of(2020, 6, 14, 0, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), new BigDecimal("35.50"), CurrencyCode.EUR));
        priceList.add(new Price(2, 35455L, 1, 1, LocalDateTime.of(2020, 6, 14, 15, 0, 0), LocalDateTime.of(2020, 6, 14, 18, 30, 0), new BigDecimal("25.45"), CurrencyCode.EUR));
        priceList.add(new Price(3, 35455L, 1, 1, LocalDateTime.of(2020, 6, 15, 0, 0, 0), LocalDateTime.of(2020, 6, 15, 11, 0, 0), new BigDecimal("30.50"), CurrencyCode.EUR));
        priceList.add(new Price(4, 35455L, 1, 1, LocalDateTime.of(2020, 6, 15, 16, 0, 0), LocalDateTime.of(2020, 12, 31, 23, 59, 59), new BigDecimal("38.95"), CurrencyCode.EUR));

        return priceList;
    }
}