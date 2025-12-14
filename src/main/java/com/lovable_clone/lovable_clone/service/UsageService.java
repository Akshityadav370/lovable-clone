package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.lovable_clone.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {

    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
