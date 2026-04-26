package com.intare_hotel.www.service;

import com.intare_hotel.www.dto.RegisterUserDto;
import com.intare_hotel.www.model.Users;
import com.intare_hotel.www.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Users> getAllUsers () {
        return usersRepository.findAll();
    }

    public int getAllUsersNumbers () {
        return usersRepository.findAll().size();
    }

    public Users getUserById (Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users getUserByEmail (String email) {
        return usersRepository.getUserByEmail(email).orElse(null);
    }

    public Users createUser (RegisterUserDto registerUserDto) {
        Users user = getUserByEmail(registerUserDto.getName());
        if (user != null) {
            return null;
        }
        Users new_user = new Users(registerUserDto.getName(), registerUserDto.getEmail(), passwordEncoder.encode(registerUserDto.getPassword()), registerUserDto.getNational_id(), registerUserDto.getGender(), registerUserDto.getPhone_number(), registerUserDto.getRole());
        return usersRepository.save(new_user);
    }

    public Users updateUserById (Long id, RegisterUserDto registerUserDto) {
        Users user = getUserById(id);
        if (user == null) {
            return null;
        }
        user.setEmail(registerUserDto.getEmail());
        user.setName(registerUserDto.getName());
        user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        user.setRole(registerUserDto.getRole());
        user.setGender(registerUserDto.getGender());
        user.setPhone_number(registerUserDto.getPhone_number());
        user.setNational_id(registerUserDto.getNational_id());
        return usersRepository.save(user);
    }

    public boolean deleteUserById (Long id) {
        Users user = getUserById(id);
        if (user != null) {
            usersRepository.delete(user);
            return true;
        }
        return false;
    }
}
