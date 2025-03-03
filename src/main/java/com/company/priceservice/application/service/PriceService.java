 package com.company.priceservice.application.service;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.application.mapper.PriceMapper;
import com.company.priceservice.domain.model.Price;
import com.company.priceservice.domain.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PriceService {

    private PriceRepository priceRepository;
    private PriceMapper priceMapper;

    public List<PriceDTO> findPrices(LocalDateTime applicationDate, Long productId, Integer brandId) {
        List<Price> priceList = priceRepository.findPrices(applicationDate, productId, brandId);
        return priceMapper.entityToDtoList(priceList);
    }
}
