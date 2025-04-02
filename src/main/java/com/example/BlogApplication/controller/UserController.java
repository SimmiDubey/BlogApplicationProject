package com.example.BlogApplication.controller;

import com.example.BlogApplication.payloads.ApiResponse;
import com.example.BlogApplication.payloads.UserDto;
import com.example.BlogApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
     UserDto createuserDto=this.userService.createUser(userDto);
     return new ResponseEntity<>(createuserDto,HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Long userId){
        UserDto updateUser = this.userService.updateUser(userDto, userId);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?>deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUserById(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted Successfully", true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return ResponseEntity.ok(this.userService.getAllUser());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUsers(@PathVariable Long userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
