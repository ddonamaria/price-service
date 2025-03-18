package com.company.priceservice.domain.repositories;

import com.company.priceservice.infrastructure.adapters.repositories.entities.PriceEntity;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<PriceEntity> findPriceByParams(@Param("productId") Long productId,
                                            @Param("brandId") Integer brandId,
                                            @Param("applicationDate") LocalDateTime applicationDate);
}