package com.intare_hotel.www.controller;

import com.intare_hotel.www.model.Users;
import com.intare_hotel.www.service.UserService;
import com.intare_hotel.www.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intare-hotel/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Users>>> getAllUsers () {
        return ApiResponse.ok("User retrieved successfully!!!!", userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Users>> getUserById (@PathVariable Long id) {
        Users user = userService.getUserById(id);
        if ( user == null) {
            return ApiResponse.notFound("Sorry user not found!!!", null);
        }
        return ApiResponse.ok("Successfully retrieved user", user);
    }
}
