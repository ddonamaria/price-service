package com.company.priceservice.infrastructure.adapters.api;

import com.company.priceservice.domain.models.Price;
import com.company.priceservice.domain.services.PriceService;
import com.company.priceservice.infrastructure.adapters.api.mappers.PriceMapper;
import com.company.priceservice.infrastructure.adapters.api.models.PriceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PriceController implements PriceApi {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    @Override
    public ResponseEntity<PriceDTO> findPriceByParams(LocalDateTime applicationDate, Long productId, Integer brandId){
        ApiUtil.validateAtLeastOneNotNull(applicationDate, productId, brandId);
        Price price = priceService.findPriceByParams(applicationDate, productId, brandId);
        return ResponseEntity.ok(priceMapper.priceToDto(price));
    }
}
