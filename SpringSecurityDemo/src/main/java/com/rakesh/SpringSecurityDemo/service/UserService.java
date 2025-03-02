package com.rakesh.SpringSecurityDemo.service;

import com.rakesh.SpringSecurityDemo.model.User;
import com.rakesh.SpringSecurityDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;
    public User saveUser(User user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

}
