package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Subscription;

import java.util.List;

/**
 * Created by Prithu on 10-03-2017.
 */
public interface SubscriptionDao {
    public void saveOrUpdate(Subscription subscription);

    public Subscription getSubscription(Subscription subscription);

    public Subscription getSubscriptionById(int id);

    public Subscription getSubscriptionByIdEager(int id);

    List<Subscription> findBySubscriptionStatus(String subscriptionStatus);

    List<Subscription> findBySubscriptionStatusAndPaymentType(String subscriptionStatus, String paymentType);

    Subscription getSubscriptionByOrderId(String orderId);
}
