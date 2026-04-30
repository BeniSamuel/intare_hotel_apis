package com.intare_hotel.www.service;

import com.intare_hotel.www.dto.LoginUserDto;
import com.intare_hotel.www.dto.RegisterUserDto;
import com.intare_hotel.www.model.Users;
import com.intare_hotel.www.util.ApiResponse;
import com.intare_hotel.www.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public Users registerUser (RegisterUserDto registerUserDto) {
        return userService.createUser(registerUserDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (LoginUserDto loginUserDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword())
            );

            Users user = userService.getUserByEmail(loginUserDto.getEmail());
            return ApiResponse.ok("Successfully Logged in user!!!!", jwtUtil.generateToken(user.getEmail()));
        } catch (Exception e) {
            return ApiResponse.badRequest("Invalid credentials", null);
        }
    }
}
