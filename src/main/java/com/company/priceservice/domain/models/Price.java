package com.company.priceservice.domain.models;

import com.company.priceservice.domain.valueobjects.CurrencyCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Price {

    private Integer priceId;
    private Long productId;
    private Integer brandId;
    private Integer priority;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private CurrencyCode currency;

}
