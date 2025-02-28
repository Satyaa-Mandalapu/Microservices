package com.example.demo.wrapper;

import lombok.*;
import com.example.demo.dto.UserDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {

    private UserDto user;
}
