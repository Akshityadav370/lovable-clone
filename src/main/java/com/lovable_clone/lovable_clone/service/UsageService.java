package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.lovable_clone.lovable_clone.dto.subscription.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {

    UsageTodayResponse getTodayUsageOfUser(Long userId);

    @Nullable PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
