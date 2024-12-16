package com.capitole.desafio.application.usecase;

import com.capitole.desafio.domain.model.Price;
import com.capitole.desafio.domain.ports.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PriceService {
  private final PriceRepository priceRepository;

  public List<Price> findApplicablePrices(LocalDateTime applicationDate, Long productId, Long brandId) {
    return priceRepository.findApplicablePrices(applicationDate, productId, brandId);
  }
}
