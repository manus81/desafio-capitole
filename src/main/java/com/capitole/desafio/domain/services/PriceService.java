package com.capitole.desafio.domain.services;

import com.capitole.desafio.domain.exceptions.PriceNotFoundException;
import com.capitole.desafio.domain.model.Price;
import com.capitole.desafio.domain.ports.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@AllArgsConstructor
@Service
public class PriceService {
  private final PriceRepository priceRepository;

  public Price findApplicablePrice(LocalDateTime applicationDate, Long productId, Long brandId) {
    return priceRepository.findApplicablePrices(productId, brandId)
        .stream()
        .filter(price -> isWithinRange(applicationDate, price))
        .max(Comparator.comparingInt(Price::getPriority))
        .orElseThrow(() -> new PriceNotFoundException("No applicable price found for productId: "
            + productId + ", brandId: " + brandId + ", date: " + applicationDate));
  }

  private boolean isWithinRange(LocalDateTime applicationDate, Price price) {
    return (applicationDate.isEqual(price.getStartDate()) || applicationDate.isAfter(price.getStartDate()))
        && (applicationDate.isEqual(price.getEndDate()) || applicationDate.isBefore(price.getEndDate()));
  }
}
