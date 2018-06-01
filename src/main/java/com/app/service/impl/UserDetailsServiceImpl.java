package com.app.service.impl;

import com.app.model.Authorities;
import com.app.repository.UserDetailsRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDetailsRepoInterface userDetailsRepo;

    @Transactional(readOnly = true)

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.app.model.User user = userDetailsRepo.findUserByUsername(username);
        User.UserBuilder builder = null;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            List<GrantedAuthority> authorities =
                    buildUserAuthority(user.getAuthorities());
            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Authorities> authoritiesSet) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

//         Build user's authorities
        for (Authorities authority : authoritiesSet) {
            setAuths.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}
