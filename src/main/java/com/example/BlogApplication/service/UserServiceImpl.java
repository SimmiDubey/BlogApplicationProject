package com.example.BlogApplication.service;

import com.example.BlogApplication.exception.ResourceNotFoundException;
import com.example.BlogApplication.model.User;
import com.example.BlogApplication.payloads.UserDto;
import com.example.BlogApplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
       User savedUser=this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Transactional
    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
    User user =this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

      user.setName(userDto.getName());
      user.setEmail(userDto.getEmail());
      user.setPassword(userDto.getPassword());
      user.setAbout(userDto.getAbout());

      User updateUser = this.userRepository.save(user);
      UserDto userDto1 = this.userToDto(updateUser);

        return userDto1;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));

        return this.userToDto(user);
    }
    @Override
    public List<UserDto> getAllUser() {
        List<User> users = this.userRepository.findAll();


        List<UserDto> userDtos = users.stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
        return userDtos;
    }


    @Override
    public void deleteUserById(Long userId) {
       User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
       this.userRepository.delete(user);
    }



    public User dtoToUser(UserDto userDto){
        User user=this.modelMapper.map(userDto, User.class);


//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto= this.modelMapper.map(user,UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());

        return userDto;
    }

}
