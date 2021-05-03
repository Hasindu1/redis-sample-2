package com.hasindu.redissample.service;

import com.hasindu.redissample.dto.UserDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hasindu_d
 */
public interface UserService {

    List<UserDto> getAllUsers() throws Exception ;

    UserDto saveUser(UserDto userDto) throws Exception;

    UserDto deleteUser(String userId) throws Exception;

    UserDto updateUser(UserDto userDto) throws Exception;



}
