package com.company.priceservice.domain.repository;

import com.company.priceservice.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findPrices(LocalDateTime applicationDate, Long productId, Integer brandId);
}