package com.example.legal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        logger.info("Root endpoint called");
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Backend API is running!");
        response.put("endpoints", new String[]{
            "/api/health",
            "/api/status", 
            "/api/debug",
            "/api/articles",
            "/api/admin/users",
            "/api/provider/questions"
        });
        response.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        logger.info("Ping endpoint called");
        return ResponseEntity.ok("pong");
    }
} 