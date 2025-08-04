package com.example.legal.controller;

import com.example.legal.dto.ArticleDto;
import com.example.legal.dto.CommentDto;
import com.example.legal.dto.LawFirmDto;
import com.example.legal.service.MockDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api") // This base path is critical
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final MockDataService mockDataService;

    public UserController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        logger.info("Test endpoint called");
        return ResponseEntity.ok("Backend API is running! Use /api/health for health check.");
    }

    @GetMapping("/simple")
    public ResponseEntity<Map<String, Object>> simple() {
        logger.info("Simple endpoint called");
        Map<String, Object> response = new HashMap<>();
        response.put("message", "API is working!");
        response.put("timestamp", System.currentTimeMillis());
        response.put("status", "ok");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Health check endpoint called");
        return ResponseEntity.ok("Backend is running!");
    }

    @GetMapping("/debug")
    public ResponseEntity<Map<String, Object>> getDebugInfo() {
        logger.info("Debug endpoint called");
        Map<String, Object> debug = new HashMap<>();
        debug.put("status", "running");
        debug.put("timestamp", System.currentTimeMillis());
        debug.put("serverPort", System.getenv("SERVER_PORT"));
        debug.put("javaVersion", System.getProperty("java.version"));
        debug.put("osName", System.getProperty("os.name"));
        debug.put("articles", mockDataService.getMockArticles().size());
        debug.put("users", mockDataService.getMockUsers().size());
        debug.put("lawFirms", mockDataService.getMockLawFirms().size());
        return ResponseEntity.ok(debug);
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        logger.info("Status endpoint called");
        Map<String, Object> status = new HashMap<>();
        status.put("status", "running");
        status.put("timestamp", System.currentTimeMillis());
        status.put("articles", mockDataService.getMockArticles().size());
        status.put("users", mockDataService.getMockUsers().size());
        status.put("lawFirms", mockDataService.getMockLawFirms().size());
        return ResponseEntity.ok(status);
    }

    @GetMapping("/articles")
    public List<ArticleDto> getPublishedArticles() {
        logger.info("GET /api/articles - Fetching published articles");
        List<ArticleDto> articles = mockDataService.getMockArticles().stream()
                .filter(article -> "Zatwierdzony".equals(article.status()))
                .collect(Collectors.toList());
        logger.info("Returning {} published articles", articles.size());
        return articles;
    }

    @PostMapping("/questions")
    public ResponseEntity<String> askQuestion(@RequestBody String questionBody) {
        logger.info("POST /api/questions - Received question: {}", questionBody);
        System.out.println("Otrzymano nowe pytanie (symulacja): " + questionBody);
        return ResponseEntity.ok("Pytanie zostało wysłane (symulacja)");
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable String id) {
        logger.info("GET /api/articles/{} - Fetching article by ID", id);
        return mockDataService.getMockArticles().stream()
                .filter(article -> article.id().equals(id))
                .findFirst()
                .map(article -> {
                    logger.info("Found article: {}", article.title());
                    return ResponseEntity.ok(article);
                })
                .orElseGet(() -> {
                    logger.warn("Article with ID {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }

    @GetMapping("/law-firms/{id}")
    public ResponseEntity<LawFirmDto> getLawFirmById(@PathVariable String id) {
        logger.info("GET /api/law-firms/{} - Fetching law firm by ID", id);
        return mockDataService.getMockLawFirms().stream()
                .filter(firm -> firm.id().equals(id))
                .findFirst()
                .map(firm -> {
                    logger.info("Found law firm: {}", firm.name());
                    return ResponseEntity.ok(firm);
                })
                .orElseGet(() -> {
                    logger.warn("Law firm with ID {} not found", id);
                    return ResponseEntity.notFound().build();
                });
    }

    // --- MISSING METHODS ---
    // This endpoint is required by the ArticleDetailView component
    @GetMapping("/articles/{articleId}/comments")
    public List<CommentDto> getCommentsForArticle(@PathVariable String articleId) {
        logger.info("GET /api/articles/{}/comments - Fetching comments for article", articleId);
        List<CommentDto> comments = mockDataService.getMockComments().stream()
                .filter(comment -> articleId.equals(comment.articleId()))
                .collect(Collectors.toList());
        logger.info("Returning {} comments for article {}", comments.size(), articleId);
        return comments;
    }

    // This endpoint is required by the ArticleDetailView component
    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<String> addComment(@PathVariable String articleId, @RequestBody String content) {
        logger.info("POST /api/articles/{}/comments - Adding comment: {}", articleId, content);
        System.out.println("Dodano nowy komentarz do artykułu " + articleId + ": " + content);
        return ResponseEntity.ok("Komentarz został dodany (symulacja)");
    }
}