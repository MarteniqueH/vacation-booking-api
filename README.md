# Vacation Booking API

A Spring Boot backend application that provides RESTful services for managing vacation bookings, customers, and excursions. This project demonstrates layered architecture, relational database integration, and API-driven development using Spring Data JPA and Spring REST.

---

## 🚀 Features

- RESTful API for vacation booking operations
- Customer management and data persistence
- Vacation package and excursion relationships
- Checkout workflow for booking vacations
- MySQL database integration using Spring Data JPA
- Cross-origin support for frontend integration (Angular-ready)
- Input validation for secure and reliable data handling

---

## 🏗️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Spring Data REST
- MySQL
- Hibernate
- Maven

---

## 📦 Project Structure

- `entities/` – JPA entity models (Customer, Vacation, Excursion, etc.)
- `dao/` – Repository interfaces for database operations
- `services/` – Business logic and checkout workflow
- `controllers/` – REST API endpoints
- `config/` – Application configuration and CORS setup

---

## 🔄 Core Functionality

### Customer Management
- Create and retrieve customer records
- Store customer data in relational database

### Vacation Packages
- View available vacation packages
- Associate excursions with vacations

### Checkout Process
- Add vacations to cart
- Process order checkout
- Generate order tracking information

---

## 🧪 Validation

The API includes validation rules to ensure:
- Required fields are provided
- Valid relationships between entities
- Proper data formatting for API requests

---

## 🌐 API Design

The application follows REST principles:
- `GET` – Retrieve data (customers, vacations, excursions)
- `POST` – Create bookings and checkout orders
- `PUT` – Update records where applicable
- `DELETE` – Remove records when needed

---

## 🧠 What I Learned

- Designing layered Spring Boot applications
- Building RESTful APIs with proper separation of concerns
- Working with relational databases using JPA/Hibernate
- Handling entity relationships in a booking system
- Structuring scalable backend applications

---

## 📌 Future Improvements

- Add authentication (JWT security layer)
- Add booking history per customer
- Deploy to cloud (AWS / Azure)
- Add logging and monitoring

---

## 👨‍💻 Author

Martenique Harmon  
GitHub: [github.com/MarteniqueH](https://github.com/MarteniqueH)
