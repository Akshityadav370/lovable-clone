package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.member.InviteMemberRequest;
import com.lovable_clone.lovable_clone.dto.member.MemberResponse;
import com.lovable_clone.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.lovable_clone.lovable_clone.entity.ProjectMember;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
