package com.example.legal.controller;

import com.example.legal.dto.ArticleDto;
import com.example.legal.dto.LawFirmDto;
import com.example.legal.service.MockDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private final MockDataService mockDataService;

    public UserController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/articles")
    public List<ArticleDto> getPublishedArticles() {
        // Zwracaj tylko zatwierdzone artykuły
        return mockDataService.getMockArticles().stream()
                .filter(article -> "Zatwierdzony".equals(article.status()))
                .collect(Collectors.toList());
    }

    @PostMapping("/questions")
    public ResponseEntity<String> askQuestion(@RequestBody String questionBody) {
        System.out.println("Otrzymano nowe pytanie (symulacja): " + questionBody);
        return ResponseEntity.ok("Pytanie zostało wysłane (symulacja)");
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable String id) {
        return mockDataService.getMockArticles().stream()
                .filter(article -> article.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/law-firms/{id}")
    public ResponseEntity<LawFirmDto> getLawFirmById(@PathVariable String id) {
        return mockDataService.getMockLawFirms().stream()
                .filter(firm -> firm.id().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}