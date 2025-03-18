package com.company.priceservice.domain.services;

import com.company.priceservice.domain.models.Price;

import java.time.LocalDateTime;

public interface PriceService {

    Price findPriceByParams(LocalDateTime applicationDate, Long productId, Integer brandId);
}