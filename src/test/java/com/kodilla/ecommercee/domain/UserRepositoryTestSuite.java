package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepositoryTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepositoryFindById() {
        //Given
        User user = new User("uncle Bob", 12, 4);

        //When
        userRepository.save(user);

        //Then
        Long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        System.out.println("Takie tam: " + readUser.get().getUsername() + ", " + readUser.get().getId());
        Assertions.assertTrue(readUser.isPresent());

        //CleanUp
        //userRepository.deleteById(id);
    }
}
