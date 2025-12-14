package com.lovable_clone.lovable_clone.dto.member;

import com.lovable_clone.lovable_clone.entity.type.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long id,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
) {
}
