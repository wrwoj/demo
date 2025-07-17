package com.example.legal.dto;

import java.time.LocalDate;

public record SubscriptionDto(String lawFirmId, String planName, String status, LocalDate nextPaymentDate) {}