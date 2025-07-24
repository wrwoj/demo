package com.example.legal.service;

import com.example.legal.dto.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MockDataService {

    public List<LawFirmDto> getMockLawFirms() {
        return List.of(
                new LawFirmDto("lf1", "Kancelaria Prawna 'Lex et Iustitia'", "ul. Prawna 1, 00-001 Warszawa", "Specjalizujemy się w prawie rodzinnym i spadkowym."),
                new LawFirmDto("lf2", "Nowak & Partnerzy", "ul. Korporacyjna 5, 02-500 Warszawa", "Liderzy w prawie pracy i ochronie danych osobowych.")
        );
    }

    public List<UserDto> getMockUsers() {
        return List.of(
                new UserDto("u0", "Robert Makłowicz", "robert.maklowicz@example.com", "Aktywny", "lf1", "Kancelaria Prawna 'Lex et Iustitia'", "OWNER"),
                new UserDto("u1", "Jan Kowalski", "jan.kowalski@example.com", "Aktywny", "lf1", "Kancelaria Prawna 'Lex et Iustitia'", "PROVIDER"),
                new UserDto("u2", "Anna Nowak", "anna.nowak@example.com", "Aktywny", "lf2", "Nowak & Partnerzy", "PROVIDER"),
                new UserDto("u3", "Piotr Zieliński", "piotr.zielinski@example.com", "Zablokowany", "lf1", "Kancelaria Prawna 'Lex et Iustitia'", "PROVIDER")
        );
    }

    public List<ArticleDto> getMockArticles() {
        String longContent = "To jest przykładowa, dłuższa treść artykułu... Lorem ipsum dolor sit amet...";
        return List.of(
                new ArticleDto("a1", "Jak napisać skuteczny pozew o rozwód?", longContent, "Jan Kowalski", "u1", "lf1", "Prawo rodzinne", LocalDate.now().minusDays(5), "Zatwierdzony", true, true),
                new ArticleDto("a2", "Spadek a zachowek - co musisz wiedzieć", longContent, "Anna Nowak", "u2", "lf2", "Prawo spadkowe", LocalDate.now().minusDays(10), "Zatwierdzony", false, true)
        );
    }

    public List<QuestionDto> getMockQuestions() {
        return List.of(
                new QuestionDto("q1", "Czy mogę odliczyć VAT za samochód firmowy?", "Adam_123", LocalDate.now().minusDays(1), "Odpowiedziane", "u1"),
                new QuestionDto("q2", "Problem z najemcą, nie płaci czynszu", "Ewa_K", LocalDate.now().minusDays(3), "Odpowiedziane", "u2"),
                new QuestionDto("q3", "Jakie są terminy przedawnienia długów?", "Kamil_S", LocalDate.now().minusDays(2), "Oczekuje na odpowiedź", null)
        );
    }

    public List<SubscriptionDto> getMockSubscriptions() {
        return List.of(
                new SubscriptionDto("lf1", "Plan Premium", "Aktywna", LocalDate.now().plusDays(20)),
                new SubscriptionDto("lf2", "Plan Standard", "Wygasła", LocalDate.now().minusDays(5))
        );
    }

    // --- THIS METHOD WAS MISSING ---
    public List<CommentDto> getMockComments() {
        return List.of(
                new CommentDto("c1", "a1", "Użytkownik_123", "Bardzo pomocny artykuł, dziękuję!", LocalDateTime.now().minusHours(5)),
                new CommentDto("c2", "a1", "Anna_Prawniczka", "Zgadzam się, świetnie podsumowane.", LocalDateTime.now().minusHours(4)),
                new CommentDto("c3", "a2", "Marek_K", "Miałem podobną sytuację, ten tekst wiele wyjaśnia.", LocalDateTime.now().minusDays(1))
        );
    }
}