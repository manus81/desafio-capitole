package com.capitole.desafio.infrastructure.adapters.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {
  private Long productId;
  private Long brandId;
  private int priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private double price;
}
