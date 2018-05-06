package com.coconet.mit.customerPortal.service;

import com.coconet.mit.appService.service.SubscriptionService;
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
    private SubscriptionService subscriptionService;
    @Override
    public void saveOrUpdate(Subscription subscription) {
        subscriptionService.saveOrUpdate(subscription);
    }

    @Override
    public Subscription getSubscription(Subscription subscription) {
        return subscriptionService.getSubscription(subscription);
    }

    @Override
    public Subscription getSubscriptionById(int id) {
        return subscriptionService.getSubscriptionById(id);
    }

    @Override
    public Subscription getSubscriptionByIdEager(int id) {
        return subscriptionService.getSubscriptionByIdEager(id);
    }

    @Override
    public Subscription getSubscriptionByOrderId(String orderId) {
        return subscriptionService.getSubscriptionByOrderId(orderId);
    }
}
