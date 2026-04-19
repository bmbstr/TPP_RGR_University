# University Management System (TPP RGR)

Проєкт на Spring Boot для керування базою даних студентів, груп та оцінок.

## Функціонал
- Авторизація та реєстрація (BCrypt).
- Ролі: **ADMIN** (повний доступ) та **USER** (тільки перегляд).
- Робота зі студентами, групами та курсами (CRUD).
- Пошук студентів за прізвищем (JDBC).

## Технології
- Java 17, Spring Boot 3.2.0
- Spring Security, Thymeleaf
- PostgreSQL, JDBC
- Lombok, Bootstrap 5

## Як запустити
1. Створити БД `university_db` у PostgreSQL.
2. Налаштувати доступ у `application.properties`.
3. Запустити через Maven: `mvn spring-boot:run`.