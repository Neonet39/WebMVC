package com.config.security;

import com.repository.UserRepository;
import com.repository.entity.Rolle;
import com.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailisServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = null;
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        try {
            user = userRepository.findByName(userName);
            for (Rolle role : user.getRolle()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolle()));
            }
        } catch (Exception e) {
           return null;
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),grantedAuthorities);
    }
}
