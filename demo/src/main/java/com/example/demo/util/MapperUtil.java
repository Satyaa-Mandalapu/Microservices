package com.example.demo.util;

import com.example.demo.entity.User;
import com.example.demo.response.UserResponse;

public class MapperUtil {

    public static UserResponse mapToResponse(User user, String message) {
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPhonenumber(), user.getAddress(), message);
    }
}
