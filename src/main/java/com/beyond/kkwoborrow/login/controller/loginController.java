package com.beyond.kkwoborrow.login.controller;

import com.beyond.kkwoborrow.login.service.loginService;
import com.beyond.kkwoborrow.login.sessionConst;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class loginController {

    private final loginService LoginService;

    @Autowired
    public loginController(loginService LoginService) {
        this.LoginService = LoginService;
    }

//    @PostMapping("/login")
//    public String login(@Valid loginForm form, BindingResult bindingResult, HttpServletRequest request, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            return "redirect:/login";
//        }
//
//        Users loginUser = loginService.login(form.getUserName(), form.getPassword());
//        if (loginUser == null) {
//            bindingResult.reject("loginFail", "Invalid email or password.");
//            return "redirect:/login";
//        }
//
//        HttpSession session = request.getSession();
//        session.setAttribute(sessionConst.LOGIN_MEMBER, loginUser);
//        return "redirect:/";
//    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
