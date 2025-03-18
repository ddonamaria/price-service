package com.company.priceservice.infrastructure.adapters.repositories;

import com.company.priceservice.domain.repositories.PriceRepository;
import com.company.priceservice.infrastructure.adapters.repositories.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Integer>, PriceRepository {

    @Query(value = """
            SELECT * FROM price p WHERE
            (:productId IS NULL OR p.product_id = :productId) AND
            (:brandId IS NULL OR p.brand_id = :brandId) AND
            (:applicationDate IS NULL OR p.start_date <= :applicationDate AND p.end_date >= :applicationDate)
            ORDER BY p.priority DESC, p.end_date DESC
            LIMIT 1""", nativeQuery = true)
    Optional<PriceEntity> findPriceByParams(@Param("productId") Long productId,
                                            @Param("brandId") Integer brandId,
                                            @Param("applicationDate") LocalDateTime applicationDate);
}
