package com.beyond.kkwoborrow.users.controller;

import com.beyond.kkwoborrow.users.dto.UserRequestDto;
import com.beyond.kkwoborrow.users.dto.UserResponseDto;
import com.beyond.kkwoborrow.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/*@RestController
@Tag(name = "Users APIs", description = "회원 관련 API 목록")*/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 추가(회원 가입)
    @PostMapping("/users")
    @Operation(summary = "회원 저장", description = "회원을 저장한다.")
    public ResponseEntity<UserResponseDto> enroll(@RequestBody UserRequestDto newUser) {
        UserResponseDto userResponseDto = userService.save(newUser);
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 회원 정보 불러오기
    @GetMapping("/users/{user-id}")
    @Operation(summary = "특정 회원 조회", description = "특정 회원의 정보를 조회한다.")
    public ResponseEntity<UserResponseDto> getUser(@Parameter(description = "회원 번호", example = "1") @PathVariable("user-id") Long userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 회원 정보 수정
    @PatchMapping("/users/{user-id}")
    @Operation(summary = "회원 정보 수정", description = "특정 회원의 정보를 수정한다.")
    public ResponseEntity<UserResponseDto> updateUser(@Parameter(description = "회원 번호", example = "1") @PathVariable("user-id") Long userId, @RequestBody UserRequestDto updateUser) {
        UserResponseDto userResponseDto =  userService.updateUser(userId, updateUser);
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // 회원 삭제
    @DeleteMapping("/users/{user-id}")
    @Operation(summary = "회원 정보 삭제", description = "특정 회원의 정보를 삭제한다.")
    public void deleteUser(@Parameter(description = "회원 번호", example = "1") @PathVariable("user-id") Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // login.html 템플릿을 반환
    }

    // 현재 로그인한 사용자 정보 가져오기
    @GetMapping("/profile")
    public String getCurrentUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // 로그인된 사용자의 이름

        UserResponseDto userResponseDto = userService.findByUsername(username);
        if (userResponseDto != null) {
            model.addAttribute("user", userResponseDto);
            return "userInfo"; // userInfo.html 템플릿 파일로 리턴
        } else {
            return "blank"; // 사용자 정보가 없을 경우 에러 페이지로 리디렉션
        }
    }

    // 로그인 처리
    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, HttpServletResponse response) throws IOException {
        UserResponseDto foundUser = userService.findByUsername(username);
        if (foundUser != null && userService.checkPassword(password, foundUser.getPassword())) {
            response.sendRedirect("/blank");
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials");
        }
    }

    @GetMapping("/blank")
    public String showBlankPage() {
        return "blank"; // templates/blank.html 파일을 반환
    }

    @GetMapping("/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "login";
    }

    @GetMapping("/user-info")
    public String getUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = null;

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            username = ((UserDetails) authentication.getPrincipal()).getUsername();
        } else {
            username = (String) authentication.getPrincipal();
        }

        UserResponseDto userResponseDto = userService.findByUsername(username);
        if (userResponseDto != null) {
            model.addAttribute("user", userResponseDto);
            return "userInfo"; // userInfo.html 템플릿 파일로 리턴
        } else {
            return "error"; // 사용자 정보가 없을 경우 에러 페이지로 리디렉션
        }
    }

    private ResponseEntity<UserResponseDto> buildResponse(UserResponseDto userResponseDto) {
        if (userResponseDto != null){
            return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 회원 가입 폼 페이지
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // register.html 템플릿을 반환
    }

    // 회원 추가(회원 가입) - HTML 폼 방식
    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserRequestDto userDto) {
        userService.save(userDto);
        return "redirect:/login"; // 회원 가입 후 로그인 페이지로 리다이렉션
    }
}
