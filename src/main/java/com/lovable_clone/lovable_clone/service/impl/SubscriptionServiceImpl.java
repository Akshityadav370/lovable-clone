package com.lovable_clone.lovable_clone.service.impl;

import com.lovable_clone.lovable_clone.dto.subscription.CheckoutRequest;
import com.lovable_clone.lovable_clone.dto.subscription.CheckoutResponse;
import com.lovable_clone.lovable_clone.dto.subscription.PortalResponse;
import com.lovable_clone.lovable_clone.dto.subscription.SubscriptionResponse;
import com.lovable_clone.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }
}
