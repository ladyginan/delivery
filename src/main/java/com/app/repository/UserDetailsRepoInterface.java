package com.app.repository;


import com.app.model.User;

public interface UserDetailsRepoInterface {
    User findUserByUsername(String username);
}

