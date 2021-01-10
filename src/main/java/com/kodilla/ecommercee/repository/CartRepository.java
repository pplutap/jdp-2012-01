package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

    @Override
    Optional<Cart> findById(Long userId);

    @Override
    void deleteById(Long userId);

    @Override
    List<Cart> findAll();

    @Override
    Cart save(Cart cart);
}
