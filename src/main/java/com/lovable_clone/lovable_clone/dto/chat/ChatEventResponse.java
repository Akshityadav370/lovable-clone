package com.lovable_clone.lovable_clone.dto.chat;


import com.lovable_clone.lovable_clone.entity.type.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
