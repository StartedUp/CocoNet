package com.coconet.mit.customerPortal.service;

import com.coconet.mit.appService.service.SubscriberService;
import com.coconet.mit.commons.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 06-02-2017.
 */
@Service
@Transactional
public class SubscriberManagerImpl implements SubscriberManager {
    @Autowired
    private SubscriberService subscriberService;
    @Override
    public List<Subscriber> list() {
        return null;
    }

    @Override
    public Subscriber get(int id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Subscriber subscriber) {
        subscriberService.saveOrUpdate(subscriber);
    }

    @Override
    public void update(Subscriber subscriber) {
        subscriberService.update(subscriber);
    }

    @Override
    public Subscriber findByEmail(String email) {
        return  subscriberService.findByEmail(email);
    }

    @Override
    public Subscriber findByEmailAndToken(String email, String token) {
        return subscriberService.findByEmailAndToken(email, token);
    }

    @Override
    public Subscriber findByToken(String token) {
        return subscriberService.findByToken(token);
    }
}
