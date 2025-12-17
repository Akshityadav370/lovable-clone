package com.lovable_clone.lovable_clone.mapper;

import com.lovable_clone.lovable_clone.dto.project.ProjectResponse;
import com.lovable_clone.lovable_clone.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);
}
