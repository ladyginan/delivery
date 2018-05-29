package com.app.configuration;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public UserDetailsService userDetailsService() {
               InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
                manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
               return manager;
    }
}