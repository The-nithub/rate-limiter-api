package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    private final RateLimiterService rateLimiterService;

    public TestController(RateLimiterService rateLimiterService) {
        this.rateLimiterService = rateLimiterService;
    }

    @GetMapping("/request")
    public String makeRequest(@RequestParam String userId) {

        boolean allowed = rateLimiterService.allowRequest(userId);

        if (allowed) {
            return "✅ Request Allowed";
        } else {
            return "❌ Too Many Requests (Rate Limit Exceeded)";
        }
    }
}