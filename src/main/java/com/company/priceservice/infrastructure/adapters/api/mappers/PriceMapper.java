package com.company.priceservice.infrastructure.adapters.api.mappers;

import com.company.priceservice.domain.models.Price;
import com.company.priceservice.infrastructure.adapters.api.models.PriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDTO priceToDto(Price price);
}

