package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RateLimiterService {

    private static final int MAX_REQUESTS = 5;
    private static final long TIME_WINDOW = 60 * 1000; // 1 minute

    private final Map<String, Queue<Long>> userRequests = new ConcurrentHashMap<>();

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        userRequests.putIfAbsent(userId, new LinkedList<>());
        Queue<Long> timestamps = userRequests.get(userId);

        synchronized (timestamps) {

            // remove old requests
            while (!timestamps.isEmpty() &&
                    currentTime - timestamps.peek() > TIME_WINDOW) {
                timestamps.poll();
            }

            if (timestamps.size() < MAX_REQUESTS) {
                timestamps.add(currentTime);
                return true;
            } else {
                return false;
            }
        }
    }
}