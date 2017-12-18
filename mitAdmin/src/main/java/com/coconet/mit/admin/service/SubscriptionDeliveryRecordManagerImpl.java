package com.coconet.mit.admin.service;

import com.coconet.mit.admin.model.SubscriptionDeliveryRecord;
import com.coconet.mit.admin.repository.SubscriptionDeliveryRecordRepository;
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
    private SubscriptionDeliveryRecordRepository subscriptionDeliveryRecordRepository;

    @Override
    public List<SubscriptionDeliveryRecord> findByDate(Date date) {
        return subscriptionDeliveryRecordRepository.findByDate(date);
    }

    @Override
    public void save(SubscriptionDeliveryRecord subscriptionDeliveryRecord) {
        subscriptionDeliveryRecordRepository.save(subscriptionDeliveryRecord);
    }
}
