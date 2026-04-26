package com.intare_hotel.www.repository;

import com.intare_hotel.www.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> getUserByEmail(String email);
}