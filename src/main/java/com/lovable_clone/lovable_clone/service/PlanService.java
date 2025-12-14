package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
    List<PlanResponse> getAllActivePlans();
}
