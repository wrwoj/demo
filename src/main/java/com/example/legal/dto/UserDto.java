// Dodajemy pole 'role'
package com.example.legal.dto;

public record UserDto(String id, String name, String email, String status, String lawFirmId, String lawFirmName, String role) {}