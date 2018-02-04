package com.coconet.mit.customerPortal.service;

import com.coconet.mit.customerPortal.dao.SubscriptionDao;
import com.coconet.mit.commons.model.Subscription;
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
