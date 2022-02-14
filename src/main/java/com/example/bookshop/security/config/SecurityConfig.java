package com.example.bookshop.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/bookins").authenticated()
                .antMatchers("/bookins/**").hasAuthority("USER")
                .antMatchers("/signUp").permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/signIn")
                .loginPage("/signIn")
                .defaultSuccessUrl("/bookins/books")
                .failureForwardUrl("/signIn?error")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll();
    }
}
