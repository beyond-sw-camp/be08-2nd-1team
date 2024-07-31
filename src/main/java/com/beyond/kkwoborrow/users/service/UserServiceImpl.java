package com.beyond.kkwoborrow.users.service;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;
import com.beyond.kkwoborrow.users.dto.UserResponseDto;
import com.beyond.kkwoborrow.users.entity.UserType;
import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto save(UserRequestDto userDto) {
        if (userDto.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        Users user = new Users();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setAddress(userDto.getAddress());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserType(UserType.valueOf("USER")); // 기본값으로 설정
        Users savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto getUser(Long userId) {
        Optional<Users> user = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE);

        return user.map(UserResponseDto::new).orElse(null);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<Users> checkUser = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE);
        if (checkUser.isPresent()) {
            Users user = checkUser.get();
            user.setUserType(UserType.LEAVE);
            userRepository.save(user);
        }
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userInfo) {
        Optional<Users> updateUser = userRepository.findByUserIdAndUserTypeNot(userId, UserType.LEAVE);

        if (updateUser.isPresent()){
            System.out.println(updateUser.get());
            updateUser.get().setUserRequestDto(userInfo);

            userRepository.save(updateUser.get());
            return new UserResponseDto(updateUser.get());
        }
        return null;
    }

    @Override
    public UserResponseDto findByUsername(String username) {
        Optional<Users> userOptional = userRepository.findByUserName(username);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            return new UserResponseDto(user);
        } else {
            return null;
        }
    }

    // 비밀번호 확인 메서드
    public boolean checkPassword(String rawPassword, String storedPassword) {
        return passwordEncoder.matches(rawPassword, storedPassword);
    }




    public void saveUser(String username, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        Users user = new Users(username, encodedPassword);
        userRepository.save(user);
    }


}
