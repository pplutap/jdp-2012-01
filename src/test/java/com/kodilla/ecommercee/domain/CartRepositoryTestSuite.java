package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartRepositoryTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Test
    public void testUserRepositoryFindById() {
        //Given
        Cart cart = new Cart();

        //When
        cartRepository.save(cart);

        //Then
        Long id = cart.getId();
        Optional<Cart> readCart = cartRepository.findById(id);
        Assertions.assertTrue(readCart.isPresent());

        //CleanUp
        cartRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryFindAll() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //Then
        Long id1 = cart1.getId();
        Long id2 = cart2.getId();
        List<Cart> listCart = cartRepository.findAll();
        Assertions.assertEquals(2, listCart.size());

        //CleanUp
        cartRepository.deleteById(id1);
        cartRepository.deleteById(id2);
    }

    @Test
    public void testUserRepositoryDeleteById() {
        //Given
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        //When
        cartRepository.save(cart1);
        cartRepository.save(cart2);

        //Then
        Long id1 = cart1.getId();
        Long id2 = cart2.getId();
        cartRepository.deleteById(id2);
        Assertions.assertEquals(1, cartRepository.findAll().size());

        //CleanUp
        cartRepository.deleteById(id1);
    }
}
