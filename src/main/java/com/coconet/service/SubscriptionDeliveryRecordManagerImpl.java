package com.coconet.service;

import com.coconet.dao.SubscriptionDeliveryRecordDao;
import com.coconet.model.SubscriptionDeliveryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 21-03-2017.
 */
@Service
@Transactional
public class SubscriptionDeliveryRecordManagerImpl implements SubscriptionDeliveryRecordManager {

    @Autowired
    private SubscriptionDeliveryRecordDao subscriptionDeliveryRecordDao;
    @Override
    public SubscriptionDeliveryRecord getSubscriptionDeliveryRecordById(int subscriptionDeliveryRecord) {
        return subscriptionDeliveryRecordDao.getSubscriptionDeliveryRecordById(subscriptionDeliveryRecord);
    }

    @Override
    public void saveOrUpdate(SubscriptionDeliveryRecord subscriptionDeliveryRecord) {
        subscriptionDeliveryRecordDao.saveOrUpdate(subscriptionDeliveryRecord);
    }
}
