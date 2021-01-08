package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTestSuite {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public OrderRepository orderRepository;

    @Test
    public void testProductRepositorySave() {
        //Given
        Product product = new Product("kurtka zimowa", "Pellentesque tempus.", 100L);

        //When
        productRepository.save(product);

        //Then
        Long id = product.getId();
        assertNotNull(id);

        //CleanUp
        productRepository.deleteById(id);
    }
}
