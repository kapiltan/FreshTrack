# FreshTrack - Warehouse Receiving & Inventory Management System

## Overview

FreshTrack is a backend application built using **Java 17**, **Spring Boot**, and **MongoDB** for managing warehouse operations.

The application allows warehouse administrators to:

- Authenticate using JWT
- Manage users and warehouses
- Upload invoices in CSV and Excel format
- Parse and validate uploaded invoices
- Store invoices and invoice items in MongoDB
- Prevent duplicate invoice uploads

The project has been designed with a modular architecture so that additional warehouse operations such as receiving, reporting, and audit logging can be added easily.

---

# Technology Stack

| Technology | Version |
|------------|----------|
| Java | 17 |
| Spring Boot | 3.x |
| Spring Security | 6 |
| MongoDB Atlas | Cloud |
| Spring Data MongoDB | Latest |
| Apache Commons CSV | Latest |
| Apache POI | Latest |
| JWT (JJWT) | Latest |
| Lombok | Latest |
| Maven | Latest |
| Swagger/OpenAPI | springdoc |

---

# Features Implemented

## Authentication

- JWT based login
- BCrypt password encryption
- Stateless authentication
- Spring Security integration

### Endpoint

```
POST /api/auth/login
```

---

## User Management

Implemented:

- Create User
- Get User
- Update User
- Delete User

Each user contains:

- First Name
- Last Name
- Email
- Password
- Role
- Warehouse Mapping
- Active Status

---

## Warehouse Management

Implemented:

- Create Warehouse
- Update Warehouse
- Delete Warehouse
- List Warehouses

Warehouse contains:

- Warehouse Name
- Warehouse Code
- City
- Active Status

---

## Invoice Upload

Supports:

- CSV Upload
- Excel (.xlsx) Upload

Implemented:

- Multipart upload
- Automatic parser selection
- CSV Parser
- Excel Parser
- Invoice validation
- Duplicate invoice validation
- Invoice persistence
- Invoice item persistence

---

# Supported Invoice Format

CSV and Excel must contain the following columns:

| Column |
|---------|
| Invoice Number |
| Warehouse Code |
| Vendor Name |
| Invoice Date |
| SKU |
| Product Name |
| Quantity |

Example:

| Invoice Number | Warehouse Code | Vendor Name | Invoice Date | SKU | Product Name | Quantity |
|----------------|----------------|-------------|--------------|-----|--------------|----------|
| INV-1001 | WH001 | ABC Traders | 2026-07-01 | SKU101 | Laptop | 10 |

---

# MongoDB Collections

Collections created automatically:

```
users

warehouses

invoices

invoice_items
```

---

# Project Structure

```
backend
│
├── auth
│
├── security
│
├── user
│
├── warehouse
│
├── invoice
│     ├── controller
│     ├── dto
│     ├── model
│     ├── parser
│     ├── repository
│     └── service
│
└── config
```

---

# Environment Variables

Create a `.env` file.

Example:

```
MONGODB_URI=<your-mongodb-uri>

JWT_SECRET=<your-secret>

JWT_EXPIRATION=86400000
```

application.properties uses:

```
spring.data.mongodb.uri=${MONGODB_URI}

jwt.secret=${JWT_SECRET}

jwt.expiration=${JWT_EXPIRATION}
```

---

# Running the Project

Clone

```
git clone https://github.com/<username>/FreshTrack.git
```

Move to backend

```
cd backend
```

Install dependencies

```
mvn clean install
```

Run

```
mvn spring-boot:run
```

Application starts on

```
http://localhost:8080
```

---

# API Documentation

Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

# APIs Available

## Authentication

POST

```
/api/auth/login
```

---

## Users

```
GET /api/users

GET /api/users/{id}

POST /api/users

PUT /api/users/{id}

DELETE /api/users/{id}
```

---

## Warehouses

```
GET /api/warehouses

POST /api/warehouses

PUT /api/warehouses/{id}

DELETE /api/warehouses/{id}
```

---

## Invoice Upload

```
POST /api/invoices/upload
```

Supports:

- CSV

- XLSX

---

# Validation

Implemented validations:

- Duplicate Invoice Number
- Empty File
- Warehouse Exists
- File Type Validation

---

# Security

Implemented

- JWT Authentication
- BCrypt Password Encryption
- Protected APIs
- Stateless Session

---

# Future Scope

The following modules were intentionally designed for future extension:

- Receiving (Scan & Count)
- Inventory Reconciliation
- Reporting Dashboard
- Audit Logging
- Export Reports
- Dashboard Analytics
- Role Based Authorization Enhancements

---

# Evaluation Guide

To evaluate this project:

## Step 1

Configure environment variables

```
MONGODB_URI

JWT_SECRET

JWT_EXPIRATION
```

---

## Step 2

Run

```
mvn spring-boot:run
```

---

## Step 3

Open Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## Step 4

Login

```
POST /api/auth/login
```

---

## Step 5

Create Warehouse

```
POST /api/warehouses
```

---

## Step 6

Create User

```
POST /api/users
```

---

## Step 7

Upload Sample CSV

```
POST /api/invoices/upload
```

---

## Step 8

Upload Sample Excel

```
POST /api/invoices/upload
```

---

## Step 9

Verify MongoDB

Collections should contain:

- users

- warehouses

- invoices

- invoice_items

---

# Design Decisions

- Layered Architecture
- Repository Pattern
- DTO Based API
- Strategy Pattern for Invoice Parsers
- JWT Authentication
- MongoDB Document Model
- Clean Separation of Concerns

---

# Assignment Status

| Module | Status |
|---------|--------|
| Authentication | ✅ Completed |
| User Management | ✅ Completed |
| Warehouse Management | ✅ Completed |
| CSV Upload | ✅ Completed |
| Excel Upload | ✅ Completed |
| Invoice Persistence | ✅ Completed |
| MongoDB Integration | ✅ Completed |
| Swagger | ✅ Completed |
| JWT Security | ✅ Completed |

Approximate completion:

**Backend: ~88–90%**

---

# Author

Kapil Tanwar

Java Backend Developer

Built as part of the FreshTrack Backend Assessment.
