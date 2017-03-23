package com.coconet.service;

import com.coconet.model.SubscriptionDeliveryRecord;

/**
 * Created by Prithu on 21-03-2017.
 */
public interface SubscriptionDeliveryRecordManager {
    public SubscriptionDeliveryRecord getSubscriptionDeliveryRecordById(int subscriptionDeliveryRecord);
    public void saveOrUpdate(SubscriptionDeliveryRecord subscriptionDeliveryRecord);
}
