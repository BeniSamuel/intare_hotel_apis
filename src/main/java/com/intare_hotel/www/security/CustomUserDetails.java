package com.intare_hotel.www.security;

import com.intare_hotel.www.model.Users;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Users users;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + users.getRole())
        );
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // or users.isAccountNonExpired()
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // or !users.isLocked()
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // or users.isCredentialsValid()
    }

    @Override
    public boolean isEnabled() {
        return true; // or users.isActive()
    }
}
