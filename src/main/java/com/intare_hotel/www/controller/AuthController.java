package com.intare_hotel.www.controller;

import com.intare_hotel.www.dto.LoginUserDto;
import com.intare_hotel.www.dto.RegisterUserDto;
import com.intare_hotel.www.model.Users;
import com.intare_hotel.www.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intare_hotel.www.service.AuthService;

@RestController
@RequestMapping("/api/intare-hotel/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<Users>> create_user (@RequestBody RegisterUserDto registerUserDto) {
        Users user = authService.registerUser(registerUserDto);
        if (user == null) {
            return ApiResponse.badRequest("Failed to create user!!!", null);
        }
        return ApiResponse.created("Successfully created user!!!", user);
    }

    @PostMapping("/login-user")
    public ResponseEntity<ApiResponse<String>> login_user (@RequestBody LoginUserDto loginUserDto) {
        return authService.loginUser(loginUserDto);
    }
}
