package com.coconet.dao;

import com.coconet.model.SubscriptionDeliveryRecord;

/**
 * Created by Prithu on 21-03-2017.
 */
public interface SubscriptionDeliveryRecordDao {
    public SubscriptionDeliveryRecord getSubscriptionDeliveryRecordById(int subscriptionDeliveryRecord);
    public void saveOrUpdate(SubscriptionDeliveryRecord subscriptionDeliveryRecord);
}
