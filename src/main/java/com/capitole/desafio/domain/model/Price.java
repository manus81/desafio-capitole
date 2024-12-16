package com.capitole.desafio.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRICE")
public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "BRAND_ID")
  private Brand brand;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private int priceList;

  private int priority;

  private double price;

  private String currency;
}
