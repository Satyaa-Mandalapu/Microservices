package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import com.example.demo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Signup - Register User
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        // Check if user already exists
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhonenumber(userRequest.getPhonenumber());
        user.setAddress(userRequest.getAddress());

        User savedUser = userRepository.save(user);
        return MapperUtil.mapToResponse(savedUser, "User registered successfully!");
    }

    // Signin - Authenticate User
    @Override
    public UserResponse authenticateUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!loginRequest.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return MapperUtil.mapToResponse(user, "Login successful");
    }

    // Fetch all users
    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> MapperUtil.mapToResponse(user, "User fetched successfully"))
                .collect(Collectors.toList());
    }
}
