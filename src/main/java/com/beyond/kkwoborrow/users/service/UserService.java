package com.beyond.kkwoborrow.users.service;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;
import com.beyond.kkwoborrow.users.dto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService {
    UserResponseDto save(UserRequestDto newUser);

    UserResponseDto getUser(Long userId);

    void deleteUser(Long userId);

    UserResponseDto updateUser(Long userId, UserRequestDto updateUser);

    UserResponseDto findByUsername(String username);

    boolean checkPassword(String rawPassword, String storedPassword);


}
