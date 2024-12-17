package com.capitole.desafio.application.usecase;

import com.capitole.desafio.domain.model.Price;
import com.capitole.desafio.domain.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class PriceUseCase {
  private final PriceService priceService;

  public Price findApplicablePrices(LocalDateTime applicationDate, Long productId, Long brandId) {
    return priceService.findApplicablePrice(applicationDate, productId, brandId);
  }
}
