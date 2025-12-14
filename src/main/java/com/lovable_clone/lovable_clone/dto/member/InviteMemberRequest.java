package com.lovable_clone.lovable_clone.dto.member;

import com.lovable_clone.lovable_clone.entity.type.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
