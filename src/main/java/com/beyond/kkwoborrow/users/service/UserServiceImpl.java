package com.beyond.kkwoborrow.users.service;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;
import com.beyond.kkwoborrow.users.dto.UserResponseDto;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto save(UserRequestDto user) {
        Users newUser = new Users(user);
        Users saveUser = userRepository.save(newUser);

        return new UserResponseDto(saveUser);
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        Optional<Users> user = userRepository.findById(userId);

        return user.map(UserResponseDto::new).orElse(null);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userInfo) {
        Optional<Users> updateUser = userRepository.findById(userId);

        if (updateUser.isPresent()){
            System.out.println(updateUser.get());
            updateUser.get().setUserRequestDto(userInfo);

            userRepository.save(updateUser.get());
            return new UserResponseDto(updateUser.get());
        }
        return null;
    }
}
