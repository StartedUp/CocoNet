package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.Subscription;

/**
 * Created by Prithu on 10-03-2017.
 */
public interface SubscriptionService {
    public void saveOrUpdate(Subscription subscription);
    public Subscription getSubscription(Subscription subscription);
    public Subscription getSubscriptionById(int id);
    public Subscription getSubscriptionByIdEager(int id);
}
