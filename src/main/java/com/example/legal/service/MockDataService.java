package com.example.legal.service;

import com.example.legal.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.legal.dto.SubscriptionDto; // Dodaj import

@Service
public class MockDataService {
    // ...

    public List<UserDto> getMockUsers() {
        return List.of(
                // Ten użytkownik jest teraz Właścicielem kancelarii "lf1"
                new UserDto("u0", "Robert Makłowicz", "robert.maklowicz@example.com", "Aktywny", "lf1", "Kancelaria Prawna 'Lex et Iustitia'", "OWNER"),
                new UserDto("u1", "Jan Kowalski", "jan.kowalski@example.com", "Aktywny", "lf1", "Kancelaria Prawna 'Lex et Iustitia'", "PROVIDER"),
                new UserDto("u2", "Anna Nowak", "anna.nowak@example.com", "Aktywny", "lf2", "Nowak & Partnerzy", "PROVIDER"),
                new UserDto("u3", "Piotr Zieliński", "piotr.zielinski@example.com", "Zablokowany", "lf1", "Kancelaria Prawna 'Lex et Iustitia'", "PROVIDER")
        );
    }

    public List<QuestionDto> getMockQuestions() {
        return List.of(
                new QuestionDto("q1", "Czy mogę odliczyć VAT za samochód firmowy?", "Adam_123", LocalDate.now().minusDays(1), "Odpowiedziane", "u1"), // Odpowiedział Jan Kowalski (lf1)
                new QuestionDto("q2", "Problem z najemcą, nie płaci czynszu", "Ewa_K", LocalDate.now().minusDays(3), "Odpowiedziane", "u2"), // Odpowiedziała Anna Nowak (lf2)
                new QuestionDto("q3", "Jakie są terminy przedawnienia długów?", "Kamil_S", LocalDate.now().minusDays(2), "Oczekuje na odpowiedź", null)
        );
    }

    public List<SubscriptionDto> getMockSubscriptions() {
        return List.of(
                new SubscriptionDto("lf1", "Plan Premium", "Aktywna", LocalDate.now().plusDays(20)),
                new SubscriptionDto("lf2", "Plan Standard", "Wygasła", LocalDate.now().minusDays(5))
        );
    }

    public List<ArticleDto> getMockArticles() {
        String longContent = "To jest przykładowa, dłuższa treść artykułu, która będzie widoczna dopiero po przejściu do szczegółów. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n\nDuis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        return List.of(
                new ArticleDto("a1", "Jak napisać skuteczny pozew o rozwód?", longContent, "Jan Kowalski", "u1", "lf1", "Prawo rodzinne", LocalDate.now().minusDays(5), "Zatwierdzony", true, true),
                new ArticleDto("a2", "Spadek a zachowek - co musisz wiedzieć", longContent, "Anna Nowak", "u2", "lf2", "Prawo spadkowe", LocalDate.now().minusDays(10), "Zatwierdzony", false, true),
                new ArticleDto("a3", "Umowa o dzieło vs umowa zlecenie w 2025", longContent, "Jan Kowalski", "u1", "lf1", "Prawo pracy", LocalDate.now().minusDays(2), "Oczekuje", false, false),
                new ArticleDto("a4", "Ochrona danych osobowych w małej firmie", longContent, "Anna Nowak", "u2", "lf2", "RODO", LocalDate.now().minusDays(20), "Zatwierdzony", false, false)
        );
    }

    public List<CategoryDto> getMockCategories() {
        return List.of(
                new CategoryDto("c1", "Prawo rodzinne"),
                new CategoryDto("c2", "Prawo spadkowe"),
                new CategoryDto("c3", "Prawo pracy"),
                new CategoryDto("c4", "Prawo cywilne"),
                new CategoryDto("c5", "RODO")
        );
    }

    public List<LawFirmDto> getMockLawFirms() {
        return List.of(
                new LawFirmDto("lf1", "Kancelaria Prawna 'Lex et Iustitia'", "ul. Prawna 1, 00-001 Warszawa", "Specjalizujemy się w prawie rodzinnym i spadkowym. Zapewniamy kompleksową obsługę prawną."),
                new LawFirmDto("lf2", "Nowak & Partnerzy", "ul. Korporacyjna 5, 02-500 Warszawa", "Liderzy w prawie pracy i ochronie danych osobowych.")
        );
    }
}