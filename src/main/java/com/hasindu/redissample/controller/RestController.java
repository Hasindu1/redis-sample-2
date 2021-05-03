package com.hasindu.redissample.controller;

import com.hasindu.redissample.dto.UserDto;
import com.hasindu.redissample.model.User;
import com.hasindu.redissample.repository.UserRepository;
import com.hasindu.redissample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hasindu_d
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user-api")
public class RestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;



    @PostMapping("/users")
    public User addSensor(@RequestBody User user) {

            userRepository.save(user);


        return user;

    }


    @GetMapping("/users")
    public List<UserDto> getUsers() throws Exception {




        return userService.getAllUsers();

    }
}
