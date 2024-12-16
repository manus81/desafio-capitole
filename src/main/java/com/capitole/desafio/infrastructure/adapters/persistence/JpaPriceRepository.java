package com.capitole.desafio.infrastructure.adapters.persistence;

import com.capitole.desafio.domain.model.Price;
import com.capitole.desafio.domain.ports.PriceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository(value = "priceRepository")
public interface JpaPriceRepository extends PriceRepository, JpaRepository<Price, Long> {

  @Query("""
           SELECT p FROM Price p 
           WHERE p.product.id = :productId
             AND p.brand.id = :brandId
             AND :applicationDate BETWEEN p.startDate AND p.endDate
           ORDER BY p.priority DESC
           """)
  List<Price> findApplicablePrices(@Param("applicationDate") LocalDateTime applicationDate,
                                   @Param("productId") Long productId,
                                   @Param("brandId") Long brandId);
}