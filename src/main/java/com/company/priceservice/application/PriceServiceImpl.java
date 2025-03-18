package com.company.priceservice.application;

import com.company.priceservice.domain.models.Price;
import com.company.priceservice.domain.services.PriceService;
import com.company.priceservice.infrastructure.adapters.api.exceptions.PriceNotFoundException;
import com.company.priceservice.infrastructure.adapters.repositories.JpaPriceRepository;
import com.company.priceservice.infrastructure.adapters.repositories.mappers.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final JpaPriceRepository priceRepository;
    private final PriceEntityMapper priceEntityMapper;

    public Price findPriceByParams(LocalDateTime applicationDate, Long productId, Integer brandId) {
        return priceRepository.findPriceByParams(productId, brandId, applicationDate)
                .map(priceEntityMapper::entityToPrice)
                .orElseThrow(() -> new PriceNotFoundException(
                        "No price found for productId: " + productId + ", brandId: " + brandId + ", date: " + applicationDate));
    }
}
