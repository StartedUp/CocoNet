package com.coconet.mit.admin.repository;

import com.coconet.mit.admin.model.SubscriptionDeliveryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Prithu on 30-03-2017.
 */
public interface SubscriptionDeliveryRecordRepository extends JpaRepository<SubscriptionDeliveryRecord, Integer> {
    public List<SubscriptionDeliveryRecord> findByDate(Date date);
}
