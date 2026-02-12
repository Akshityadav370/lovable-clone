package com.lovable_clone.lovable_clone.service;


import com.lovable_clone.lovable_clone.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);
}
