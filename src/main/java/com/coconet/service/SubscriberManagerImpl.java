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
    public void delete(int id) {

    }

    @Override
    public Subscriber findByEmail(String email) {
        return  subscriberDao.findByEmail(email);
    }
}
