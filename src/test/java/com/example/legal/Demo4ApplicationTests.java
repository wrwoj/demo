package com.example.legal;

import com.example.legal.service.MockDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.TestPropertySource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class Demo4ApplicationTests {

    @Autowired
    private MockDataService mockDataService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMockDataServiceLoadsData() {
        // Test that mock data is loaded correctly
        assert mockDataService.getMockArticles().size() > 0 : "Mock articles should be loaded";
        assert mockDataService.getMockUsers().size() > 0 : "Mock users should be loaded";
        assert mockDataService.getMockLawFirms().size() > 0 : "Mock law firms should be loaded";
        assert mockDataService.getMockCategories().size() > 0 : "Mock categories should be loaded";
        assert mockDataService.getMockQuestions().size() > 0 : "Mock questions should be loaded";
        assert mockDataService.getMockComments().size() > 0 : "Mock comments should be loaded";
        assert mockDataService.getMockSubscriptions().size() > 0 : "Mock subscriptions should be loaded";
    }

    @Test
    void testPublishedArticlesFilter() {
        // Test that only published articles are returned
        var articles = mockDataService.getMockArticles().stream()
                .filter(article -> "Zatwierdzony".equals(article.status()))
                .toList();
        assert articles.size() > 0 : "Should have at least one published article";
    }
}
