package com.example.legal.dto;

import java.time.LocalDateTime;

public record CommentDto(
        String id,
        String articleId,
        String author,
        String content,
        LocalDateTime createdAt
) {}