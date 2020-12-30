package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CartDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String groupId;

    public void add(ProductDto productDto) {

    }

    public void delete(ProductDto productDto) {

    }
}
