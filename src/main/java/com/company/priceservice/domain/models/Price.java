package com.company.priceservice.domain.models;

import com.company.priceservice.domain.valueobjects.CurrencyCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @Column(name = "price_id")
    private Integer priceId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    private CurrencyCode currency;
}

