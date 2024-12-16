package com.capitole.desafio.domain.ports;

import com.capitole.desafio.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

  List<Price> findApplicablePrices(LocalDateTime applicationDate, Long productId, Long brandId);
}
