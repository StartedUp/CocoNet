package com.coconet.dao;

import com.coconet.model.Subscription;

/**
 * Created by Prithu on 10-03-2017.
 */
public interface SubscriptionDao {
    public void saveOrUpdate(Subscription subscription);
    public Subscription getSubscription(Subscription subscription);
    public Subscription getSubscriptionById(int id);
}
