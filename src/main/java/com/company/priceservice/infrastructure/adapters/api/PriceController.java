package com.company.priceservice.infrastructure.adapters.api;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.application.ports.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PriceController implements PriceApi {

    private final PriceService priceService;

    @Override
    public ResponseEntity<PriceDTO> findPriceByParams(LocalDateTime applicationDate, Long productId, Integer brandId){
        ApiUtil.validateAtLeastOneNotNull(applicationDate, productId, brandId);
        PriceDTO price = priceService.findPriceByParams(applicationDate, productId, brandId);
        return ResponseEntity.ok(price);
    }
}
