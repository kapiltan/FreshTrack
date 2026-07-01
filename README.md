# FreshTrack – Warehouse Invoice & Receiving Management System

## Overview

FreshTrack is a warehouse inventory and invoice management system built using **Spring Boot**, **MongoDB Atlas**, and **JWT Authentication**.

The application enables warehouse administrators and operators to manage warehouses, users, invoices, inventory receiving, reporting, and audit logs through a secure role-based system.

---

# Technology Stack

### Backend

- Java 17
- Spring Boot 3
- Spring Security
- JWT Authentication
- Spring Data MongoDB
- MongoDB Atlas
- Apache Commons CSV
- Apache POI (Excel)
- Lombok
- Maven

### Database

- MongoDB Atlas

### API Documentation

- Swagger / OpenAPI

---

# Features

## Authentication & Authorization

- JWT Login
- BCrypt Password Encryption
- Role Based Access Control (RBAC)
- Admin and Operator roles
- Protected REST APIs

---

## User Management

- Create Users
- Update Users
- Delete Users
- List Users
- Activate/Deactivate Users

---

## Warehouse Management

- Create Warehouse
- Update Warehouse
- Delete Warehouse
- List Warehouses
- Warehouse Status Management

---

## User-Warehouse Mapping

- Assign multiple warehouses to users
- Restrict warehouse visibility based on user role

---

## Invoice Upload

Supports:

- CSV Upload
- Excel (.xlsx) Upload

Features

- Automatic parsing
- Invoice validation
- Duplicate invoice detection
- Warehouse validation
- Invoice persistence
- Invoice Item persistence

---

## Invoice Listing

- Search
- Pagination
- Sorting
- Warehouse Filter
- Vendor Filter

---

## Receiving Module

- Scan SKU
- Update received quantity
- Partial receiving
- Complete receiving
- Receiving history

---

## Reporting

- Total invoices
- Pending invoices
- Completed invoices
- Warehouse-wise reports
- Export reports

---

## Audit Logging

Tracks

- Login
- User Creation
- Warehouse Creation
- Invoice Upload
- Receiving Activity

---

# Project Structure

```
FreshTrack
│
├── backend
│   ├── auth
│   ├── config
│   ├── security
│   ├── user
│   ├── warehouse
│   ├── invoice
│   ├── receiving
│   ├── report
│   ├── audit
│   └── common
│
├── frontend
│
└── README.md
```

---

# API Modules

## Authentication

```
POST /api/auth/login
```

---

## Users

```
GET    /api/users
GET    /api/users/{id}
POST   /api/users
PUT    /api/users/{id}
DELETE /api/users/{id}
```

---

## Warehouses

```
GET    /api/warehouses
POST   /api/warehouses
PUT    /api/warehouses/{id}
DELETE /api/warehouses/{id}
```

---

## Invoice Upload

```
POST /api/invoices/upload
```

Supports

- CSV
- XLSX

---

## Invoice Listing

```
GET /api/invoices
```

Supports

- Pagination
- Search
- Filters

---

## Receiving

```
POST /api/receiving
```

---

## Reports

```
GET /api/reports
```

---

# Database Collections

```
users

warehouses

invoices

invoice_items

audit_logs
```

---

# Environment Variables

Create a `.env` file inside the backend directory.

Example

```
MONGODB_URI=<your-mongodb-uri>

JWT_SECRET=<your-secret-key>

JWT_EXPIRATION=86400000
```

The application reads these variables using

```
application.properties
```

```
spring.data.mongodb.uri=${MONGODB_URI}

jwt.secret=${JWT_SECRET}

jwt.expiration=${JWT_EXPIRATION}
```

---

# Installation

Clone the repository

```
git clone https://github.com/<your-username>/FreshTrack.git
```

Navigate

```
cd FreshTrack/backend
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

# Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

# MongoDB Setup

Create a free MongoDB Atlas cluster.

Create a database user.

Whitelist your IP.

Copy the connection string into

```
MONGODB_URI
```

No collections need to be created manually.

Collections are automatically created when the application stores data.

---

# Sample Invoice Format

CSV and Excel both use the following structure.

| Invoice Number | Warehouse Code | Vendor Name | Invoice Date | SKU | Product Name | Quantity |
|----------------|---------------|------------|--------------|-----|--------------|----------|
| INV1001 | WH001 | ABC Traders | 2026-07-01 | SKU001 | Laptop | 10 |

---

# Testing Guide (For Evaluator)

The following sequence is recommended while evaluating the application.

## Step 1

Run MongoDB Atlas.

Configure environment variables.

Run the application.

---

## Step 2

Open Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## Step 3

Authenticate

```
POST /api/auth/login
```

Copy JWT token.

Click **Authorize** in Swagger.

Paste

```
Bearer <JWT>
```

---

## Step 4

Create Warehouses

Verify

- Create
- Update
- Delete
- List

---

## Step 5

Create Users

Verify

- Password Encryption
- Roles
- Warehouse Assignment

---

## Step 6

Upload Invoice

Test

CSV Upload

Excel Upload

Verify

- Invoice Created
- Invoice Items Created
- Duplicate Validation

---

## Step 7

Verify Invoice Listing

Test

Pagination

Sorting

Searching

Filtering

---

## Step 8

Verify Receiving

Update received quantities.

Verify inventory status updates.

---

## Step 9

Verify Reports

Generate reports.

Verify export functionality.

---

## Step 10

Verify Audit Logs

Perform operations and confirm audit entries are recorded.

---

# Security

- JWT Authentication
- BCrypt Password Hashing
- Role Based Authorization
- Environment Variables
- MongoDB Atlas Authentication

---

# Design Principles

- Layered Architecture
- SOLID Principles
- Dependency Injection
- Repository Pattern
- DTO Pattern
- Strategy Pattern (CSV / Excel Parser)
- Builder Pattern
- Separation of Concerns

---

# Future Improvements

- Docker Deployment
- Kubernetes
- Redis Cache
- Email Notifications
- Barcode Scanner Integration
- Unit Tests
- Integration Tests
- CI/CD Pipeline

---

# Author

Kapil Tanwar

Backend Developer

Java • Spring Boot • MongoDB • REST APIs • JWT • Microservices
