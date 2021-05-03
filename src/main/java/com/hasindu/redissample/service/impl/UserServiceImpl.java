package com.hasindu.redissample.service.impl;

import com.hasindu.redissample.dto.UserDto;
import com.hasindu.redissample.model.User;
import com.hasindu.redissample.repository.UserRepository;
import com.hasindu.redissample.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hasindu_d
 */
@Service
public class UserServiceImpl implements UserService {

      @Autowired
      private UserRepository userRepository;

      @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() throws Exception {
        List<User> userList = new ArrayList<>();
        List<UserDto> userDtoList = new ArrayList<>();
        Iterable<User> usersIterable =  userRepository.findAll();
        usersIterable.forEach(userList::add);
        userList.forEach(user -> {
            userDtoList.add(modelMapper.map(user, UserDto.class));
        });
        return userDtoList;
    }

    @Override
    public UserDto saveUser(UserDto userDto) throws Exception {
        return null;
    }

    @Override
    public UserDto deleteUser(String userId) throws Exception {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) throws Exception {
        return null;
    }
}
