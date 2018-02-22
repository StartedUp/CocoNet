package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.LoggedInSubscriber;
import com.coconet.mit.commons.model.Subscriber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Prithu on 01-03-2017.
 */

public class SubscriberDetailsService implements UserDetailsService {
    @Autowired
    private SubscriberService subscriberService;

    private static final Log _log = LogFactory.getLog(SubscriberDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Subscriber subscriber= subscriberService.findByEmail(email);
            if (subscriber == null) {
                _log.info("Subscriber "+email+" not found");
                return null;
            }
            LoggedInSubscriber loggedInSubscriber =new LoggedInSubscriber(subscriber.getFirstName(), subscriber.getPassword(),subscriber.isActive(),true,true,true,getAuthorities());
            loggedInSubscriber.setEmail(subscriber.getEmail()); loggedInSubscriber.setId(subscriber.getId()); loggedInSubscriber.setFirstName(subscriber.getFirstName());
            loggedInSubscriber.setLastName(subscriber.getLastName());
            return loggedInSubscriber;
        }catch (Exception e){
            _log.info("Exception fetching subscriber by email ", e);
            throw new UsernameNotFoundException("Subcriber Email not found");
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }
}
