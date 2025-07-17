package com.example.legal.controller;

import com.example.legal.dto.*;
import com.example.legal.service.MockDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final MockDataService mockDataService;

    public AdminController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return mockDataService.getMockUsers();
    }

    @PostMapping("/users/{id}/block")
    public ResponseEntity<String> blockUser(@PathVariable String id) {
        System.out.println("Symulacja blokowania użytkownika o ID: " + id);
        return ResponseEntity.ok("Użytkownik zablokowany (symulacja)");
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        System.out.println("Symulacja usuwania użytkownika o ID: " + id);
        return ResponseEntity.ok("Użytkownik usunięty (symulacja)");
    }

    @GetMapping("/articles")
    public List<ArticleDto> getArticles() {
        return mockDataService.getMockArticles();
    }

    @PostMapping("/articles/{id}/approve")
    public ResponseEntity<String> approveArticle(@PathVariable String id) {
        System.out.println("Symulacja zatwierdzania artykułu o ID: " + id);
        return ResponseEntity.ok("Artykuł zatwierdzony (symulacja)");
    }

    @PostMapping("/articles/{id}/promote")
    public ResponseEntity<String> promoteArticle(@PathVariable String id) {
        System.out.println("Symulacja promowania artykułu o ID: " + id);
        return ResponseEntity.ok("Artykuł promowany (symulacja)");
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return mockDataService.getMockCategories();
    }

    @PostMapping("/law-firms")
    public ResponseEntity<String> addLawFirm(@RequestBody NewLawFirmRequestDto lawFirmRequest) {
        System.out.println("Symulacja dodawania nowej kancelarii: " + lawFirmRequest.name());
        return ResponseEntity.ok("Kancelaria została dodana (symulacja)");
    }
}