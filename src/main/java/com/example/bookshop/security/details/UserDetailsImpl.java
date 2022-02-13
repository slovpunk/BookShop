package com.example.bookshop.security.details;

import com.example.bookshop.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

//при помощи этого класс мы настраиваем взаимодействие между security и user

public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    //роль пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = user.getRole().toString();
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    //аккаунт не просрочен
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Заблокирован аккаунт
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //не просрочен ли пароль
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //активный ли аккаунт, который сейчас заходит
    @Override
    public boolean isEnabled() {
        return true;
    }
}
