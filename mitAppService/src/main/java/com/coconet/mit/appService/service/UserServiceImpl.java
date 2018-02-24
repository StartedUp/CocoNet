package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.User;
import com.coconet.mit.dbService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 21-03-2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
