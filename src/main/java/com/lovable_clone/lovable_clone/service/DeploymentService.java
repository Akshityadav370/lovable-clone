package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.deploy.DeployResponse;

public interface DeploymentService {
    DeployResponse deploy(Long projectId);
}
