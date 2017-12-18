package com.coconet.mit.admin.service;

import com.coconet.mit.admin.model.Subscription;
import com.coconet.mit.admin.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prithu on 29-03-2017.
 */
@Service
@Transactional
public class SubscriptionManagerImpl implements SubscriptionManager {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> findBySubscriptionStatus(String subscriptionStatus) {
        return subscriptionRepository.findBySubscriptionStatus(subscriptionStatus);
    }

    @Override
    public List<Subscription> findBySubscriptionStatusAndPaymentType(String subscriptionStatus, String paymentType) {
        return subscriptionRepository.findBySubscriptionStatusAndPaymentType(subscriptionStatus, paymentType);
    }

    @Override
    public Subscription findById(Integer id) {
        return subscriptionRepository.findById(id);
    }
}
