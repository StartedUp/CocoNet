package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.User;

/**
 * Created by Prithu on 21-03-2017.
 */
public interface UserService {
    public User findByEmail(String email);
    public void save(User user);
}
