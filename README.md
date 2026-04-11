# FEAA-DAM — Internships Manager

> **Dezvoltarea Aplicațiilor Multistrat** · FEAA 2023-2024

A full-stack, multi-tier application for managing internship programmes within a company. The system covers interns, internship periods, teams, tasks, reviews, and equipment, streamlining the process for both interns and their mentors.

---

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Database Setup](#database-setup)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [API Endpoints](#api-endpoints)
- [Features](#features)
- [License](#license)

---

## Overview

**InternshipsManager** is a versatile application for managing internship stages within a company. It provides modules for:

- **Interns** – track intern employees, their assignments, and progress
- **Internship Periods** – create, update, and cancel internship programmes
- **Teams** – organise employees and interns into departmental teams
- **Tasks** – assign and monitor tasks throughout the internship
- **Reviews** – evaluate intern performance with a strategy-based grading system
- **Equipment** – manage equipment allocated to interns

---

## Architecture

The project follows a classic **3-tier (multi-layer) architecture**:

```
┌─────────────────────────────────┐
│  Presentation Layer             │
│  Windows Forms Desktop App      │
│  (C# / .NET — frontend/)        │
└────────────────┬────────────────┘
                 │  REST (HTTP/JSON)
┌────────────────▼────────────────┐
│  Business Logic Layer           │
│  Spring Boot REST API           │
│  (Java 17 — InternshipsManager/)│
└────────────────┬────────────────┘
                 │  JPA / Hibernate
┌────────────────▼────────────────┐
│  Data Layer                     │
│  PostgreSQL Database            │
└─────────────────────────────────┘
```

---

## Tech Stack

| Layer      | Technology |
|------------|------------|
| Backend    | Java 17, Spring Boot 3, Spring Data JPA, Spring Security, Lombok |
| Database   | PostgreSQL |
| Frontend   | C# (.NET), Windows Forms |
| Build tool | Maven (backend), MSBuild (frontend) |

---

## Project Structure

```
FEAA-DAM/
├── InternshipsManager/          # Spring Boot backend
│   ├── src/main/java/com/project/InternshipsManager/
│   │   ├── controller/          # REST controllers
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── model/               # JPA entities & enums
│   │   │   └── utils/
│   │   │       └── designPattern/  # Strategy pattern for mark evaluation
│   │   ├── repository/          # Spring Data repositories
│   │   ├── security/            # Spring Security configuration
│   │   └── service/             # Business logic services
│   └── src/main/resources/
│       └── application.properties
├── frontend/                    # Windows Forms desktop client
│   ├── Models/                  # C# model classes
│   ├── Presenters/              # MVP presenters
│   ├── RestApi/                 # REST client services
│   └── Views/                   # WinForms views
├── script.sql                   # Sample seed data
└── LICENSE
```

---

## Getting Started

### Prerequisites

- **Java 17+**
- **Maven 3.8+**
- **PostgreSQL 14+**
- **.NET Framework / Visual Studio** (for the frontend)

---

### Database Setup

1. Create a PostgreSQL database named `internships_manager_db`:

   ```sql
   CREATE DATABASE internships_manager_db;
   ```

2. (Optional) Load the sample seed data:

   ```bash
   psql -U postgres -d internships_manager_db -f script.sql
   ```

---

### Backend Setup

1. Open `InternshipsManager/src/main/resources/application.properties` and update the database credentials if needed:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/internships_manager_db
   spring.datasource.username=postgres
   spring.datasource.password=<your_password>
   ```

2. Build and run the backend:

   ```bash
   cd InternshipsManager
   ./mvnw spring-boot:run
   ```

   The API will be available at **`http://localhost:8081`**.

---

### Frontend Setup

1. Open `frontend/InternshipsFrontEnd.sln` in **Visual Studio**.
2. Restore NuGet packages.
3. Build and run the solution — the desktop application will connect to the backend API at `http://localhost:8081`.

---

## API Endpoints

| Resource          | Method | Endpoint                                         | Description                  |
|-------------------|--------|--------------------------------------------------|------------------------------|
| Internships       | GET    | `/api/internships`                               | List all internships         |
| Internships       | GET    | `/api/internships/{id}`                          | Get internship by ID         |
| Internships       | POST   | `/api/internships/addInternship`                 | Create a new internship      |
| Internships       | PUT    | `/api/internships/updateInternship/{id}`         | Update an internship         |
| Internships       | DELETE | `/api/internships/deleteInternship/{id}`         | Cancel an internship         |
| Intern Employees  | GET    | `/api/internEmployees`                           | List all intern employees    |
| Tasks             | GET    | `/api/tasks`                                     | List all tasks               |
| Reviews           | GET    | `/api/reviews`                                   | List all reviews             |
| Equipment         | GET    | `/api/equipment`                                 | List all equipment           |

---

## Features

- **CRUD** operations for internships, intern employees, tasks, reviews, and equipment
- **Team management** across five departments: Backend Development, Frontend Development, QA, Infrastructure, and Support
- **Strategy design pattern** for flexible intern performance evaluation (simple mark, positive-message, and custom strategies)
- **Facade pattern** simplifying mark evaluation from the service layer
- **MVP architecture** in the Windows Forms frontend for clean separation of concerns
- **Spring Security** integration (CSRF disabled for REST API consumption)
- **JPA/Hibernate** with automatic schema update (`ddl-auto=update`)

---

## License

This project is licensed under the terms of the [LICENSE](LICENSE) file included in this repository.

