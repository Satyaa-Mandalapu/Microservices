package com.example.demo.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private String phonenumber;
    private String address;

    public UserResponse(String username, String email, String phonenumber, String address, String message) {
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.message = message;
    }

    private String message;
}
