package com.coconet.mit.admin.service;

import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;
import com.coconet.mit.dbService.dao.SubscriptionDeliveryRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Prithu on 30-03-2017.
 */
@Service
@Transactional
public class SubscriptionDeliveryRecordManagerImpl implements SubscriptionDeliveryRecordManager {

    @Autowired
    private SubscriptionDeliveryRecordDao subscriptionDeliveryRecordDao;

    @Override
    public List<SubscriptionDeliveryRecord> findByDate(Date date) {
        return subscriptionDeliveryRecordDao.findByDate(date);
    }

    @Override
    public void save(SubscriptionDeliveryRecord subscriptionDeliveryRecord) {
        subscriptionDeliveryRecordDao.save(subscriptionDeliveryRecord);
    }
}
