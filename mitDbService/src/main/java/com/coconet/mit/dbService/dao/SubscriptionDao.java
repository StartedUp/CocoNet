package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Subscription;

/**
 * Created by Prithu on 10-03-2017.
 */
public interface SubscriptionDao {
    public void saveOrUpdate(Subscription subscription);
    public Subscription getSubscription(Subscription subscription);
    public Subscription getSubscriptionById(int id);
    public Subscription getSubscriptionByIdEager(int id);
}
