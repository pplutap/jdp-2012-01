package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void test() {
        Order order = orderRepository.save(new Order(1L, "abc", new ArrayList<>()));
        Optional<Order> foundEntity = orderRepository.findById(order.getId());
        assertTrue(foundEntity.isPresent());
    }
}
