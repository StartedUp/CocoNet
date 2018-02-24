package com.coconet.mit.admin.service;

import com.coconet.mit.appService.service.SubscriptionService;
import com.coconet.mit.commons.model.Subscription;
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
    private SubscriptionService subscriptionService;

    @Override
    public List<Subscription> findBySubscriptionStatus(String subscriptionStatus) {
        return subscriptionService.findBySubscriptionStatus(subscriptionStatus);
    }

    @Override
    public List<Subscription> findBySubscriptionStatusAndPaymentType(String subscriptionStatus, String paymentType) {
        return subscriptionService.findBySubscriptionStatusAndPaymentType(subscriptionStatus, paymentType);
    }

    @Override
    public Subscription findById(Integer id) {
        return subscriptionService.getSubscriptionById(id);
    }
}
