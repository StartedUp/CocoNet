package com.coconet.mit.customerPortal.dao;

import com.coconet.mit.customerPortal.model.Subscription;

/**
 * Created by Prithu on 10-03-2017.
 */
public interface SubscriptionDao {
    public void saveOrUpdate(Subscription subscription);
    public Subscription getSubscription(Subscription subscription);
    public Subscription getSubscriptionById(int id);
    public Subscription getSubscriptionByIdEager(int id);
}
