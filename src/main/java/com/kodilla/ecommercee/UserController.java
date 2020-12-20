package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getUser")
    public UserDto getUser(Long userId) {
        return new UserDto(1L, "TestUser", 1, 123456);
    }

    @DeleteMapping(value = "deleteUser")
    public void deleteUser(Long userId) {

    }

    @PutMapping(value = "updateUser")
    public UserDto updateUser(UserDto userDto) {
        return new UserDto(1L, "TestUpdate", 1, 125478);
    }

    @PostMapping(value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(UserDto userDto) {

    }
}
