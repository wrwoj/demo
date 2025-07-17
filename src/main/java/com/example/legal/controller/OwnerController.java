package com.example.legal.controller;

import com.example.legal.dto.QuestionDto;
import com.example.legal.dto.SubscriptionDto;
import com.example.legal.dto.UserDto;
import com.example.legal.service.MockDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    private final MockDataService mockDataService;

    public OwnerController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    // Zwraca pytania, na które odpowiedzieli prawnicy z danej kancelarii
    @GetMapping("/answered-questions/{lawFirmId}")
    public List<QuestionDto> getAnsweredQuestions(@PathVariable String lawFirmId) {
        List<String> providerIds = mockDataService.getMockUsers().stream()
                .filter(user -> lawFirmId.equals(user.lawFirmId()) && "PROVIDER".equals(user.role()))
                .map(UserDto::id)
                .toList();

        return mockDataService.getMockQuestions().stream()
                .filter(q -> providerIds.contains(q.answeredByProviderId()))
                .collect(Collectors.toList());
    }

    // Zwraca subskrypcję dla danej kancelarii
    @GetMapping("/subscription/{lawFirmId}")
    public ResponseEntity<SubscriptionDto> getSubscription(@PathVariable String lawFirmId) {
        return mockDataService.getMockSubscriptions().stream()
                .filter(s -> lawFirmId.equals(s.lawFirmId()))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Symuluje dodanie nowego prawnika
    @PostMapping("/lawyers")
    public ResponseEntity<String> addLawyer(@RequestBody UserDto newLawyer) {
        System.out.println("Owner dodaje nowego prawnika: " + newLawyer.name());
        return ResponseEntity.ok("Konto prawnika zostało utworzone i oczekuje na aktywację (symulacja)");
    }
}