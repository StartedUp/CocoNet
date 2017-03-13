package com.coconet.service;

import com.coconet.model.Subscription;

/**
 * Created by Prithu on 10-03-2017.
 */
public interface SubscriptionManager {
    public void saveOrUpdate(Subscription subscription);
    public Subscription getSubscription(Subscription subscription);
}
