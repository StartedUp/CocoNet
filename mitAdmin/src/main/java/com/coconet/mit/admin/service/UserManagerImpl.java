package com.coconet.mit.admin.service;

import com.coconet.mit.admin.dao.UserDao;
import com.coconet.mit.commons.model.User;
import com.coconet.mit.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 21-03-2017.
 */
@Service
@Transactional
public class UserManagerImpl implements UserManager {
    @Autowired
    private UserDao userDao;
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
