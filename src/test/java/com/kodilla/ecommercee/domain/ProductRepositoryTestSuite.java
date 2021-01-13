package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTestSuite {

    @Autowired
    public ProductRepository productRepository;

    @Test
    public void testProductRepositorySave() {
        //Given
        Product product = new Product("kurtka zimowa", "Pellentesque tempus.", 100L);

        //When
        productRepository.save(product);

        //Then
        Long id = product.getId();
        Optional<Product> readProduct = productRepository.findById(id);
        Assertions.assertTrue(readProduct.isPresent());

        //CleanUp
        productRepository.deleteById(id);
    }
}
