package com.company.priceservice.application.mapper;

import com.company.priceservice.application.dto.PriceDTO;
import com.company.priceservice.domain.model.Price;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDTO entityToDto(Price price);

    List<PriceDTO> entityToDtoList(List<Price> priceList);
}
