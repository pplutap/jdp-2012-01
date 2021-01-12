package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
        Assertions.assertTrue(readUser.isPresent());

        //CleanUp
        userRepository.deleteById(id);
    }

    @Test
    public void testUserRepositoryFindAll() {
        //Given
        User user1 = new User("Anonymous developer", 190, 13);
        User user2 = new User("Kotlin programmer", 230, 7);

        //When
        userRepository.save(user1);
        userRepository.save(user2);

        //Then
        Long id1 = user1.getId();
        Long id2 = user2.getId();
        List<User> listUsers = userRepository.findAll();
        Assertions.assertEquals(2, listUsers.size());

        //CleanUp
        userRepository.deleteById(id1);
        userRepository.deleteById(id2);
    }

    @Test
    public void testUserRepositoryDeleteById() {
        //Given
        User user1 = new User("John Smith", 124, 71);
        User user2 = new User("John Doe", 50, 18);

        //When
        userRepository.save(user1);
        userRepository.save(user2);

        //Then
        Long id1 = user1.getId();
        Long id2 = user2.getId();
        userRepository.deleteById(id2);
        Assertions.assertEquals(1, userRepository.findAll().size());

        //CleanUp
        userRepository.deleteById(id1);
    }
}
