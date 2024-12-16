package com.capitole.desafio.infrastructure.adapters.web.controllers;

import com.capitole.desafio.application.usecase.PriceService;
import com.capitole.desafio.domain.model.Price;
import com.capitole.desafio.infrastructure.adapters.web.dtos.PriceDTO;
import com.capitole.desafio.infrastructure.adapters.web.mappers.PriceMapper;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/prices")
class PriceController {
  private final PriceService priceService;
  private final PriceMapper priceMapper;

  @GetMapping("/applicable")
  public ResponseEntity<List<PriceDTO>> getApplicablePrice(
      @RequestParam("applicationDate")
      @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate applicationDate,
      @RequestParam("productId") Long productId,
      @RequestParam("brandId") Long brandId) {

    List<Price> prices = priceService.findApplicablePrices(applicationDate.atStartOfDay(), productId, brandId);

    List<PriceDTO> applicablePrices = prices.stream()
        .map(priceMapper::toDTO)
        .toList();

    return ResponseEntity.ok(applicablePrices);
  }
}
