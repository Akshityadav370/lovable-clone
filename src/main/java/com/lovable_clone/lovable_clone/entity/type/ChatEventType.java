package com.lovable_clone.lovable_clone.entity.type;

public enum ChatEventType {
    THOUGHT,      // "Thought for 2s"
    MESSAGE,      // Standard conversational text
    FILE_EDIT,    // Code generation <file>
    TOOL_LOG      // "Reading file..." <tool>
}
