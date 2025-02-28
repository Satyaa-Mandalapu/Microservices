package com.example.demo.service;

import com.example.demo.request.UserRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);
    UserResponse authenticateUser(LoginRequest loginRequest);
    List<UserResponse> getAllUsers();
}
