package com.capstone.ecommerce.security;

import com.capstone.ecommerce.dao.UserRepository;
import com.capstone.ecommerce.exception.types.InvalidInputException;
import com.capstone.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepo.findByUsername(username).orElseThrow(
                ()-> new InvalidInputException("EMAIL NOT FOUND")
                );

        return new MyUserPrincipal(user);
    }
}
