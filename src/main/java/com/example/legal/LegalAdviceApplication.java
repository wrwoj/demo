package com.example.legal;

import com.example.legal.service.MockDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LegalAdviceApplication {

    private static final Logger logger = LoggerFactory.getLogger(LegalAdviceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LegalAdviceApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
        logger.info("=== Legal Advice Application Started ===");
        logger.info("Application is ready to serve requests");
        
        // Verify mock data is loaded
        MockDataService mockDataService = event.getApplicationContext().getBean(MockDataService.class);
        logger.info("Mock data verification:");
        logger.info("- Articles: {}", mockDataService.getMockArticles().size());
        logger.info("- Users: {}", mockDataService.getMockUsers().size());
        logger.info("- Law Firms: {}", mockDataService.getMockLawFirms().size());
        logger.info("- Categories: {}", mockDataService.getMockCategories().size());
        logger.info("- Questions: {}", mockDataService.getMockQuestions().size());
        logger.info("- Comments: {}", mockDataService.getMockComments().size());
        logger.info("- Subscriptions: {}", mockDataService.getMockSubscriptions().size());
        logger.info("=== Application Ready ===");
    }
}