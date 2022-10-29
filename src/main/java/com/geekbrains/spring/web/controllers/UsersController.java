package com.geekbrains.spring.web.controllers;


import com.geekbrains.spring.web.converters.UserConverter;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.services.UserService;
import com.geekbrains.spring.web.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final UserConverter userConverter;


    @PostMapping
    public UserDto saveNewProduct(@RequestBody UserDto userDto) {
        System.out.println(userDto);

        userValidator.validate(userDto);
        User user = userConverter.dtoToEntity(userDto);
        user = userService.save(user);
        return userConverter.entityToDto(user);
    }
}
