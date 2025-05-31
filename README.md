# ☑️ ddudu

Java + Spring Boot 기반의 할 일(Todo) 관리 REST API입니다.

## 🚀 기술 스택

- Java 17
- Spring Boot 3.x
- Spring Web, Spring Data JPA
- H2 Database
- Swagger (springdoc-openapi)

## 📌 주요 기능

- 할 일 등록 (POST `/todos`)
- 할 일 전체 조회 (GET `/todos`)
- 할 일 상태 변경 (PATCH `/todos/{id}`)
- 할 일 삭제 (DELETE `/todos/{id}`)

## 📘 Swagger UI

<img width="1494" alt="Image" src="https://github.com/user-attachments/assets/1b613640-8111-40f6-9e5f-24d15c56589f" />

## 🛠 실행 방법

```bash
# Gradle 빌드
./gradlew build

# 서버 실행
./gradlew bootRun

```
접속: http://localhost:8080

---

## 📄 API 문서 (Swagger)

👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---
