package com.coconet.service;

import com.coconet.model.Subscriber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Prithu on 01-03-2017.
 */
@Service
public class SubscriberDetailsService implements UserDetailsService {
    @Autowired
    private SubscriberManager subscriberManager;

    private static final Log _log = LogFactory.getLog(SubscriberDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Subscriber subscriber=subscriberManager.findByEmail(email);
            if (subscriber == null) {
                _log.info("Subscriber email not found");
                return null;
            }
            return new org.springframework.security.core.userdetails.User(subscriber.getFirstName(), subscriber.getPassword(),getAuthorities());
        }catch (Exception e){
            throw new UsernameNotFoundException("Subcriber Email not found");
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }
}
