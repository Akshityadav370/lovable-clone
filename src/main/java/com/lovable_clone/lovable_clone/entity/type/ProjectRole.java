package com.lovable_clone.lovable_clone.entity.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.lovable_clone.lovable_clone.entity.type.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(EDIT, VIEW, DELETE, VIEW_MEMBERS),
    VIEWER(Set.of(VIEW, VIEW_MEMBERS)),
    OWNER(Set.of(EDIT, VIEW, DELETE, MANAGE_MEMBERS, VIEW_MEMBERS));

    ProjectRole(ProjectPermission... permissions) {
        this.permissions = Set.of(permissions);
    }

    private final Set<ProjectPermission> permissions;
}
