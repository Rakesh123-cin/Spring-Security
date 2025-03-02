package com.rakesh.SpringSecurityDemo.service;

import com.rakesh.SpringSecurityDemo.model.User;
import com.rakesh.SpringSecurityDemo.model.UserPrincipal;
import com.rakesh.SpringSecurityDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findById(username).orElse(null);
        if(user==null)
        {
            System.out.println("User not found..........");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
