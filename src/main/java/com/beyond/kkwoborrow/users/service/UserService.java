package com.beyond.kkwoborrow.users.service;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;
import com.beyond.kkwoborrow.users.dto.UserResponseDto;

public interface UserService {
    UserResponseDto save(UserRequestDto newUser);

    UserResponseDto getUser(Long userId);

    void deleteUser(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDto updateUser);
}
