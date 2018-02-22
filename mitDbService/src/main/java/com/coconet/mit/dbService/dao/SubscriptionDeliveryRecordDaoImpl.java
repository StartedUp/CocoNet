package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.SubscriptionDeliveryRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Prithu on 21-03-2017.
 */
@Repository
public class SubscriptionDeliveryRecordDaoImpl implements SubscriptionDeliveryRecordDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public SubscriptionDeliveryRecord getSubscriptionDeliveryRecordById(int subscriptionDeliveryRecord) {
        return (SubscriptionDeliveryRecord)this.sessionFactory.getCurrentSession().get(SubscriptionDeliveryRecord.class,subscriptionDeliveryRecord);
    }
    @Override
    public void saveOrUpdate(SubscriptionDeliveryRecord subscriptionDeliveryRecord){
        this.sessionFactory.getCurrentSession().saveOrUpdate(subscriptionDeliveryRecord);
    }
}
