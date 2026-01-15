package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.subscription.CheckoutRequest;
import com.lovable_clone.lovable_clone.dto.subscription.CheckoutResponse;
import com.lovable_clone.lovable_clone.dto.subscription.PortalResponse;
import com.lovable_clone.lovable_clone.dto.subscription.SubscriptionResponse;
import com.lovable_clone.lovable_clone.entity.type.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String id, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String id);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String subId);
}
