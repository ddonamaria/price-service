package com.company.priceservice.application.mappers;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.domain.models.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDTO entityToDto(Price price);
}

