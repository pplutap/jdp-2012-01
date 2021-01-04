package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final UserRepository repository;
    private final OrderRepository orderRepository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(final Long id) {
        return repository.findById(id);
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public void deleteUser(final Long userId) {
        repository.deleteById(userId);
    }

    public List<Order> getAllOrders() { return orderRepository.findAll(); }

    public Optional<Order> getOrder(final Long id) { return orderRepository.findById(id); }

    public Order saveOrder(final Order order) {return orderRepository.save(order); }

    public void deleteOrder(final Long orderId) { orderRepository.deleteById(orderId); }
}
