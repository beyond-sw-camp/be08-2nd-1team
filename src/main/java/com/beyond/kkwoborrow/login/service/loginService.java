package com.beyond.kkwoborrow.login.service;

import com.beyond.kkwoborrow.users.entity.Users;
import com.beyond.kkwoborrow.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class loginService {

    private static UserRepository userRepository = null;

    @Autowired
    public loginService(UserRepository userRepository) {
        loginService.userRepository = userRepository;
    }

}
