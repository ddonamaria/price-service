package com.company.priceservice.infrastructure.adapters.repositories.mappers;

import com.company.priceservice.domain.models.Price;
import com.company.priceservice.infrastructure.adapters.repositories.entities.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

    Price entityToPrice(PriceEntity priceEntity);
}

