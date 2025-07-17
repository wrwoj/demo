// Dodajemy 'answeredByProviderId' i aktualizujemy status
package com.example.legal.dto;

import java.time.LocalDate;

public record QuestionDto(String id, String title, String author, LocalDate date, String status, String answeredByProviderId) {}