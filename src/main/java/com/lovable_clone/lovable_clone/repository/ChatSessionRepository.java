package com.lovable_clone.lovable_clone.repository;

import com.lovable_clone.lovable_clone.entity.ChatSession;
import com.lovable_clone.lovable_clone.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}