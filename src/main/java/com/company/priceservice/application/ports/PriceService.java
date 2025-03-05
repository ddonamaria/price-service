package com.company.priceservice.application.ports;

import com.company.priceservice.application.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {

    PriceDTO findPriceByParams(LocalDateTime applicationDate, Long productId, Integer brandId);
}