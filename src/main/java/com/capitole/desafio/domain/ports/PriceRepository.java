package com.capitole.desafio.domain.ports;

import com.capitole.desafio.domain.model.Price;

import java.util.List;

public interface PriceRepository {

  List<Price> findApplicablePrices(Long productId, Long brandId);
}
