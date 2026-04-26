package com.intare_hotel.www.dto;

import com.intare_hotel.www.enums.Gender;
import com.intare_hotel.www.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDto {
    private String name;
    private String email;
    private String password;
    private Long national_id;
    private Gender gender;
    private Role role;
    private Long phone_number;
}
