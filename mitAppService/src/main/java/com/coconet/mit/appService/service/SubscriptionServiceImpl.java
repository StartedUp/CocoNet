package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.Subscription;
import com.coconet.mit.dbService.dao.SubscriptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prithu on 10-03-2017.
 */
@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
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

    @Override
    public List<Subscription> findBySubscriptionStatus(String subscriptionStatus) {
        return subscriptionDao.findBySubscriptionStatus(subscriptionStatus);
    }

    @Override
    public List<Subscription> findBySubscriptionStatusAndPaymentType(String subscriptionStatus, String paymentType) {
        return subscriptionDao.findBySubscriptionStatusAndPaymentType(subscriptionStatus, paymentType);
    }

    @Override
    public Subscription getSubscriptionByOrderId(String orderId) {
        return subscriptionDao.getSubscriptionByOrderId(orderId);
    }
}
