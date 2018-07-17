package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;
import com.coconet.mit.dbService.repository.SubscriptionDeliveryRecordRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Prithu on 21-03-2017.
 */
@Repository
public class SubscriptionDeliveryRecordDaoImpl implements SubscriptionDeliveryRecordDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SubscriptionDeliveryRecordRepository subscriptionDeliveryRecordRepository;
    @Override
    public SubscriptionDeliveryRecord getSubscriptionDeliveryRecordById(int subscriptionDeliveryRecord) {
//        return (SubscriptionDeliveryRecord)this.sessionFactory.getCurrentSession().get(SubscriptionDeliveryRecord.class,subscriptionDeliveryRecord);
        return subscriptionDeliveryRecordRepository.findById(subscriptionDeliveryRecord);
    }

    @Override
    public List<SubscriptionDeliveryRecord> findByDate(Date date) {
        return subscriptionDeliveryRecordRepository.findByDate(date);
    }

    @Override
    public void save(SubscriptionDeliveryRecord subscriptionDeliveryRecord) {
        subscriptionDeliveryRecordRepository.save(subscriptionDeliveryRecord);
    }

    @Override
    public void saveOrUpdate(SubscriptionDeliveryRecord subscriptionDeliveryRecord){
        subscriptionDeliveryRecordRepository.save(subscriptionDeliveryRecord);
    }
}
