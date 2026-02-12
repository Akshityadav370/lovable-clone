package com.lovable_clone.lovable_clone.dto.chat;

import com.lovable_clone.lovable_clone.entity.ChatEvent;
import com.lovable_clone.lovable_clone.entity.ChatSession;
import com.lovable_clone.lovable_clone.entity.type.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        ChatSession chatSession,
        MessageRole role,
        List<ChatEvent> events,
        String content,
        Integer tokensUsed,
        Instant createdAt
) {
}
