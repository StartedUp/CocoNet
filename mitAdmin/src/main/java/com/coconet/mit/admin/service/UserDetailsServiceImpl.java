package com.coconet.mit.admin.service;

import com.coconet.mit.commons.model.LoggedInUser;
import com.coconet.mit.commons.model.Role;
import com.coconet.mit.commons.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Prithu on 22-03-2017.
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserManager userManager;

    private static final Log _log = LogFactory.getLog(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            _log.info("user email :"+email);
            User user=userManager.findByEmail(email);
            _log.info("user "+user);
            if (user == null) {
                _log.info("user "+email+" not found");
                return null;
            }
            LoggedInUser loggedInUser =new LoggedInUser(user.getUsername(), user.getPassword(),true,true,true,true,getAuthorities(user));
            loggedInUser.setEmail(user.getEmail()); loggedInUser.setId(user.getId()); loggedInUser.setUsername(user.getUsername());
            return loggedInUser;
        }catch (Exception e){
            e.printStackTrace();
            throw new UsernameNotFoundException("user Email not found");
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles()){
            _log.info("role.getRolename() :"+role.getRolename());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return grantedAuthorities;
    }
}
