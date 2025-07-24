package com.example.legal.controller;

import com.example.legal.dto.ArticleDto;
import com.example.legal.dto.CommentDto;
import com.example.legal.dto.LawFirmDto;
import com.example.legal.service.MockDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api") // This base path is critical
public class UserController {

    private final MockDataService mockDataService;

    public UserController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/articles")
    public List<ArticleDto> getPublishedArticles() {
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

    // --- MISSING METHODS ---
    // This endpoint is required by the ArticleDetailView component
    @GetMapping("/articles/{articleId}/comments")
    public List<CommentDto> getCommentsForArticle(@PathVariable String articleId) {
        return mockDataService.getMockComments().stream()
                .filter(comment -> articleId.equals(comment.articleId()))
                .collect(Collectors.toList());
    }

    // This endpoint is required by the ArticleDetailView component
    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<String> addComment(@PathVariable String articleId, @RequestBody String content) {
        System.out.println("Dodano nowy komentarz do artykułu " + articleId + ": " + content);
        return ResponseEntity.ok("Komentarz został dodany (symulacja)");
    }
}