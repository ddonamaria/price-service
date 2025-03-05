package com.company.priceservice.application.services;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.application.mappers.PriceMapper;
import com.company.priceservice.application.ports.PriceService;
import com.company.priceservice.infrastructure.adapters.repositories.JpaPriceRepository;
import com.company.priceservice.infrastructure.exceptions.PriceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final JpaPriceRepository priceRepository;
    private final PriceMapper priceMapper;



    public PriceDTO findPriceByParams(LocalDateTime applicationDate, Long productId, Integer brandId) {
        return priceRepository.findPriceByParams(productId, brandId, applicationDate)
                .map(priceMapper::entityToDto)
                .orElseThrow(() -> new PriceNotFoundException(
                        "No price found for productId: " + productId + ", brandId: " + brandId + ", date: " + applicationDate));
    }
}
