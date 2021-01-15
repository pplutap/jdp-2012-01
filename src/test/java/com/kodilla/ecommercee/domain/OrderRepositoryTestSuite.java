package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderRepositoryTestSuite {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void testOrderRepositorySave() {
        //Given
        Order orderJacket = new Order("Order Jacket");
        //When
        orderRepository.save(orderJacket);
        //Then
        Long id = orderJacket.getId();
        Assertions.assertNotNull(id);
        //CleanUp
        orderRepository.deleteById(id);
    }

    @Test
    public void testOrderRepositoryFindById() {
        //Given
        Order orderJacket = new Order("Order Jacket");
        //When
        orderRepository.save(orderJacket);
        //Then
        Long id = orderJacket.getId();
        Optional<Order> readOrder = orderRepository.findById(id);
        Assertions.assertNotNull(readOrder.isPresent());
        //CleanUp
        orderRepository.deleteById(id);
    }


    @Test
    public void testOrderRepositoryFindAll() {
        //Given
        Order orderJacket = new Order("Order Jacket");
        Order orderJeans = new Order("Order Jeans");
        //When
        orderRepository.save(orderJacket);
        orderRepository.save(orderJeans);
        //Then
        Long idOrderJacket = orderJacket.getId();
        Long idOrderJeans = orderJeans.getId();
        List<Order> listOrders = orderRepository.findAll();
        Assertions.assertEquals(2, listOrders.size());
        //CleanUp
        orderRepository.deleteById(idOrderJacket);
        orderRepository.deleteById(idOrderJeans);
    }

    @Test
    public void testOrderRepositoryDeleteById() {
        //Given
        Order orderJacket = new Order("Order Jacket");
        Order orderJeans = new Order("Order Jeans");
        //When
        orderRepository.save(orderJacket);
        orderRepository.save(orderJeans);
        //Then
        Long idOrderJacket = orderJacket.getId();
        Long idOrderJeans = orderJeans.getId();
        orderRepository.deleteById(idOrderJeans);
        Assertions.assertEquals(1, orderRepository.findAll().size());
        //CleanUp
        orderRepository.deleteById(idOrderJacket);
    }
}
