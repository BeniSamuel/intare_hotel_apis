package com.intare_hotel.www.model;

import com.intare_hotel.www.enums.Gender;
import com.intare_hotel.www.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Setter
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    @Column(unique = true, nullable = false)
    private Long national_id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Long phone_number;

    private String password;

    public Users (String name, String email, String password, Long national_id, Gender gender, Long phone_number, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.national_id = national_id;
        this.gender = gender;
        this.phone_number = phone_number;
        this.role = role;
    }
}
