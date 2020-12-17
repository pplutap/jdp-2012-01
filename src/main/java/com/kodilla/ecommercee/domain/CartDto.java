package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartDto {
    private Long id;
    private String name;

    public void add(ProductDto productDto) {

    }

    public void delete(ProductDto productDto) {

    }
}
