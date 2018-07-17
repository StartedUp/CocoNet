package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;

/**
 * Created by Prithu on 21-03-2017.
 */
public interface SubscriptionDeliveryRecordService {
    public SubscriptionDeliveryRecord getSubscriptionDeliveryRecordById(int subscriptionDeliveryRecord);
    public void saveOrUpdate(SubscriptionDeliveryRecord subscriptionDeliveryRecord);
}
