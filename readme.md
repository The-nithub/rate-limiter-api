# 🚀 Rate Limiter API

A Spring Boot-based REST API that implements request throttling to prevent abuse and ensure system stability.

## 🔧 Tech Stack
- Java
- Spring Boot
- ConcurrentHashMap
- Maven

## ⚙️ Features
- Limits requests per user within a time window
- Sliding window rate limiting logic
- Handles concurrent requests efficiently
- RESTful API design

## 📌 API Endpoint

GET /api/request?userId=123

## ✅ Behavior

- First 5 requests → Allowed
- After limit → Blocked (Rate Limit Exceeded)

## 🧠 Concept Used
Sliding Window Rate Limiting Algorithm

## 🚀 How to Run

1. Clone repo
2. Run DemoApplication.java
3. Open:
   http://localhost:8080/api/request?userId=123