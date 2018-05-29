package com.app.repository;

import org.springframework.security.core.userdetails.User;

public interface UserDetailsRepoInterface {
    User findUserByUsername(String username);
}

