# Smart Task Workflow Backend

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-Backend-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-orange)

---

## Overview

A backend service built with Spring Boot for managing users and task workflows. The system provides secure authentication, structured task operations, and user-level analytics, following a clean and maintainable layered architecture.

---

## Key Features

* Stateless authentication using JWT
* RESTful API design
* Task management with full CRUD operations
* Pagination, filtering, and sorting support
* User-specific task retrieval
* Analytical insights based on task status and priority

---

## Architecture

The application follows a layered architecture:

```
Controller → Service → Repository → Database
```

This structure ensures separation of concerns and scalability.

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA (Hibernate)
* Spring Security (JWT)
* PostgreSQL
* Maven

---

## Project Structure

```
src/main/java/com/mayank/demo/
 ├── controller/
 ├── service/
 ├── repo/
 ├── model/
 └── security/

src/main/resources/
 └── application.properties

database/
 └── seed.sql
```

---

## Getting Started

### 1. Clone Repository

```
git clone https://github.com/aroramayank163/smart-task-backend.git
cd YOUR_REPO
```

---

### 2. Database Setup

Create database:

```
createdb taskdb
```

Import schema and sample data:

```
psql -U postgres -d taskdb -f database/seed.sql
```

---

### 3. Configuration

Update the following file:

```
src/main/resources/application.properties
```

```
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.app.jwtSecret=YOUR_SECRET_KEY
spring.app.jwtExpirationMs=86400000
```

---

### 4. Run Application

```
./mvnw spring-boot:run
```

or run `DemoApplication.java` from your IDE.

---

## API Endpoints

### Authentication

```
POST /hello/auth/signup
POST /hello/auth/login
```

### Task Management

```
GET    /hello/tasks
POST   /hello/tasks
PUT    /hello/tasks/{id}
DELETE /hello/tasks/{id}
GET    /hello/tasks/user/{userId}
```

### Analytics

```
GET /hello/tasks/analytics/user/{userId}
```

---

## Security

* JWT-based authentication
* Stateless session management
* Custom authentication filter integrated with Spring Security

---

## Testing

Use Postman or any REST client.

For protected endpoints:

```
Authorization: Bearer <token>
```

---

## Notes

* `seed.sql` is included for quick database initialization
* Replace configuration values before running locally
* Designed for local development and demonstration

---

## Author

Mayank Arora
GitHub: https://github.com/aroramayank163
