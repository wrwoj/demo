// Dodajemy 'content' i 'lawFirmId'
package com.example.legal.dto;

import java.time.LocalDate;

public record ArticleDto(
        String id,
        String title,
        String content, // Pełna treść artykułu
        String author,
        String authorId, // ID autora
        String lawFirmId, // ID kancelarii
        String category,
        LocalDate date,
        String status,
        boolean isFeatured,
        boolean isPromoted
) {}