package com.coconet.mit.admin.service;

import com.coconet.mit.appService.service.UserService;
import com.coconet.mit.commons.model.User;
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
    private UserService userService;

    @Override
    public void save(User user) {
        userService.save(user);
    }
    public User findByEmail(String email){
        return userService.findByEmail(email);
    }
}
