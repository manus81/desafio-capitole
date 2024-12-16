package com.capitole.desafio.infrastructure.adapters.web.mappers;

import com.capitole.desafio.infrastructure.adapters.web.dtos.PriceDTO;
import com.capitole.desafio.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;

@Mapper(componentModel = "spring", mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT)
public interface PriceMapper {
  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "brand.id", target = "brandId")
  PriceDTO toDTO(Price price);
}
