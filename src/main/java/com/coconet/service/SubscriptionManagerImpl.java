package com.coconet.service;

import com.coconet.dao.SubscriptionDao;
import com.coconet.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 10-03-2017.
 */
@Service
@Transactional
public class SubscriptionManagerImpl implements SubscriptionManager{
    @Autowired
    private SubscriptionDao subscriptionDao;
    @Override
    public void saveOrUpdate(Subscription subscription) {
        subscriptionDao.saveOrUpdate(subscription);
    }

    @Override
    public Subscription getSubscription(Subscription subscription) {
        return subscriptionDao.getSubscription(subscription);
    }

    @Override
    public Subscription getSubscriptionById(int id) {
        return subscriptionDao.getSubscriptionById(id);
    }

    @Override
    public Subscription getSubscriptionByIdEager(int id) {
        return subscriptionDao.getSubscriptionByIdEager(id);
    }
}
