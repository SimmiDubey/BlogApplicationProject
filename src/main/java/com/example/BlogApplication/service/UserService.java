package com.example.BlogApplication.service;

import com.example.BlogApplication.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

     UserDto createUser(UserDto user);
     UserDto updateUser(UserDto user,Long userId);
     UserDto getUserById(Long userId);
      List<UserDto> getAllUser();
      void deleteUserById(Long userId);

}
