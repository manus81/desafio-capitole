package com.capitole.desafio.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldReturnPrices_whenValidRequest() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/prices/applicable")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-14T00:00"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(35.50))
        .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
  }

  @Test
  void shouldReturnNotFound_whenNoPrices() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/prices/applicable")
            .param("productId", "9999")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-14T00:00"))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  void shouldReturnHighestPriorityPrice_whenMultipleValidPrices() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/prices/applicable")
            .param("productId", "35455")
            .param("brandId", "1")
            .param("applicationDate", "2020-06-14T16:00"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(25.45))
        .andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("EUR"));
  }
}
