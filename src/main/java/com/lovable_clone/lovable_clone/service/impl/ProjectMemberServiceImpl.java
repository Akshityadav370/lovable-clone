package com.lovable_clone.lovable_clone.service.impl;

import com.lovable_clone.lovable_clone.dto.member.InviteMemberRequest;
import com.lovable_clone.lovable_clone.dto.member.MemberResponse;
import com.lovable_clone.lovable_clone.dto.member.UpdateMemberRoleRequest;
import com.lovable_clone.lovable_clone.entity.Project;
import com.lovable_clone.lovable_clone.entity.ProjectMember;
import com.lovable_clone.lovable_clone.entity.ProjectMemberId;
import com.lovable_clone.lovable_clone.entity.User;
import com.lovable_clone.lovable_clone.mapper.ProjectMemberMapper;
import com.lovable_clone.lovable_clone.repository.ProjectMemberRepository;
import com.lovable_clone.lovable_clone.repository.ProjectRepository;
import com.lovable_clone.lovable_clone.repository.UserRepository;
import com.lovable_clone.lovable_clone.security.AuthUtil;
import com.lovable_clone.lovable_clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {
    ProjectMemberRepository projectMemberRepository;
    ProjectRepository projectRepository;
    UserRepository userRepository;
    AuthUtil authUtil;

    ProjectMemberMapper projectMemberMapper;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId) {
       return projectMemberRepository.findByIdProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

//        if (!project.getOwner().getId().equals(userId)) {
//            throw new RuntimeException("Not Allowed!");
//        }
//        TODO: the above can be done with security config (auth)

        User invitee = userRepository.findByUsername(request.username()).orElseThrow();

        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Cannot invite once again!");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();

        projectMemberRepository.save(member);

        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request) {
        Project project = getAccessibleProjectById(projectId, authUtil.getCurrentUserId());

//        if (!project.getOwner().getId().equals(userId)) {
//            throw new RuntimeException("Not Allowed!");
//        }
//        TODO

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId) {
        Project project = getAccessibleProjectById(projectId, authUtil.getCurrentUserId());

//        if (!project.getOwner().getId().equals(userId)) {
//            throw new RuntimeException("Not Allowed!");
//        }
//        TODO

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member doesn't exist in invitees!");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    // INTERNAL FUNCTIONS
    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId).orElseThrow();
    }
}
