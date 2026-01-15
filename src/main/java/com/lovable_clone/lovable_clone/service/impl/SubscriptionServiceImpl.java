package com.lovable_clone.lovable_clone.service.impl;

import com.lovable_clone.lovable_clone.dto.subscription.CheckoutRequest;
import com.lovable_clone.lovable_clone.dto.subscription.CheckoutResponse;
import com.lovable_clone.lovable_clone.dto.subscription.PortalResponse;
import com.lovable_clone.lovable_clone.dto.subscription.SubscriptionResponse;
import com.lovable_clone.lovable_clone.entity.type.SubscriptionStatus;
import com.lovable_clone.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId) {

    }

    @Override
    public void updateSubscription(String id, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId) {

    }

    @Override
    public void cancelSubscription(String id) {

    }

    @Override
    public void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd) {

    }

    @Override
    public void markSubscriptionPastDue(String subId) {

    }
}
