package com.app.repository.impl;

import com.app.model.User;
import com.app.repository.UserDetailsRepoInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Slf4j
@Repository
@AllArgsConstructor
public class UserDetailsRepo implements UserDetailsRepoInterface {
    private final SessionFactory factory;

    @Override
    public User findUserByUsername(String username) {
        return factory.getCurrentSession().get(User.class, username);
    }
}
