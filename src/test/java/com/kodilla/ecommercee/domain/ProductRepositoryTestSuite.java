package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

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

    @Test
    public void testProductRepositoryFindById() {
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

    @Test
    public void testProductRepositoryFindAll() {
        //Given
        Product product1 = new Product("kurtka zimowa", "Pellentesque tempus.", 100L);
        Product product2 = new Product("płaszcz", "Pellentesque tempus.", 150L);

        //When
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        Long id1 = product1.getId();
        Long id2 = product2.getId();
        List<Product> listUsers = productRepository.findAll();
        Assertions.assertEquals(2, listUsers.size());

        //CleanUp
        productRepository.deleteById(id1);
        productRepository.deleteById(id2);
    }

    @Test
    public void testProductRepositoryDeleteById() {
        //Given
        Product product1 = new Product("kurtka zimowa", "Pellentesque tempus.", 100L);
        Product product2 = new Product("płaszcz", "Pellentesque tempus.", 150L);

        //When
        productRepository.save(product1);
        productRepository.save(product2);

        //Then
        Long id1 = product1.getId();
        Long id2 = product2.getId();
        productRepository.deleteById(id2);
        Assertions.assertEquals(1, productRepository.findAll().size());

        //CleanUp
        productRepository.deleteById(id1);
    }
}
