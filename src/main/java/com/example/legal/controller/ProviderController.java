package com.example.legal.controller;

import com.example.legal.dto.NewArticleRequestDto; // Dodaj import
import com.example.legal.dto.QuestionDto;
import com.example.legal.service.MockDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

    private final MockDataService mockDataService;

    public ProviderController(MockDataService mockDataService) {
        this.mockDataService = mockDataService;
    }

    @GetMapping("/questions")
    public List<QuestionDto> getQuestions() {
        return mockDataService.getMockQuestions();
    }

    @PostMapping("/questions/{id}/answer")
    public ResponseEntity<String> markAsAnswered(@PathVariable String id) {
        System.out.println("Symulacja oznaczania pytania jako odpowiedziane, ID: " + id);
        return ResponseEntity.ok("Pytanie oznaczone jako odpowiedziane (symulacja)");
    }

    // NOWA METODA
    @PostMapping("/articles")
    public ResponseEntity<String> addArticle(@RequestBody NewArticleRequestDto articleRequest) {
        // W realnej aplikacji tutaj byłby zapis do bazy danych
        System.out.println("Otrzymano nowy artykuł do weryfikacji:");
        System.out.println("Tytuł: " + articleRequest.title());
        System.out.println("Kategoria: " + articleRequest.category());

        return ResponseEntity.ok("Artykuł został przesłany do weryfikacji (symulacja)");
    }
}