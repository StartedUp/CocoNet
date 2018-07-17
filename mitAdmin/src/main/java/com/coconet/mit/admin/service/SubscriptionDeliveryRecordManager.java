package com.coconet.mit.admin.service;

import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by Prithu on 30-03-2017.
 */
public interface SubscriptionDeliveryRecordManager {
    public List<SubscriptionDeliveryRecord> findByDate(Date date);
    public void save(SubscriptionDeliveryRecord subscriptionDeliveryRecord);
}
