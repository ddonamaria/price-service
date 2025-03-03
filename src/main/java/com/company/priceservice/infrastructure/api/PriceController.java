package com.company.priceservice.infrastructure.api;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.application.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@AllArgsConstructor
public class PriceController implements PriceApi {

    private final PriceService priceService;

    @Override
    public ResponseEntity<List<PriceDTO>> findPrices(LocalDateTime applicationDate, Long productId, Integer brandId){
        List<PriceDTO> prices = priceService.findPrices(applicationDate, productId, brandId);
        return ResponseEntity.ok(prices);
    }


}
