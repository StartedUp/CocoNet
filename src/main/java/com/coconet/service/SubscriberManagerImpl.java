package com.coconet.service;

import com.coconet.dao.SubscriberDao;
import com.coconet.model.Subscriber;
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
    private SubscriberDao subscriberDao;
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
        subscriberDao.saveOrUpdate(subscriber);
    }

    @Override
    public void update(Subscriber subscriber) {
        subscriberDao.update(subscriber);
    }

    @Override
    public Subscriber findByEmail(String email) {
        return  subscriberDao.findByEmail(email);
    }

    @Override
    public Subscriber findByEmailAndToken(String email, String token) {
        return subscriberDao.findByEmailAndToken(email, token);
    }

    @Override
    public Subscriber findByToken(String token) {
        return subscriberDao.findByToken(token);
    }
}
