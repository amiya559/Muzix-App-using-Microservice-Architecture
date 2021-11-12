package com.amiya.jwt.service;

import com.amiya.jwt.Exceptions.UserAlreadyExistsException;
import com.amiya.jwt.model.User;
import com.amiya.jwt.model.UserDTO;
import com.amiya.jwt.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public User save(UserDTO user) throws UserAlreadyExistsException {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setYearOfBirth(user.getYearOfBirth());
        newUser.setPreferredLanguage(user.getPreferredLanguage());
        newUser.setPreferredGenre(user.getPreferredGenre());
        User user1 = userDao.save(newUser);
        if (user1 == null)
            throw new UserAlreadyExistsException("User Already Exist");
        return user1;
    }
}
