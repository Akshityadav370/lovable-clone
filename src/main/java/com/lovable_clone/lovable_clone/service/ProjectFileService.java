package com.lovable_clone.lovable_clone.service;

import com.lovable_clone.lovable_clone.dto.project.FileContentResponse;
import com.lovable_clone.lovable_clone.dto.project.FileNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectFileService {
    List<FileNode> getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);

    void saveFile(Long projectId, String filePath, String fileContent);
}
