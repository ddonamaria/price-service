package com.company.priceservice.domain.repositories;

import com.company.priceservice.domain.model.Price;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findPriceByParams(@Param("productId") Long productId,
                                      @Param("brandId") Integer brandId,
                                      @Param("applicationDate") LocalDateTime applicationDate);
}