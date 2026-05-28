````md id="x4yqkg"
# Job Portal Backend System

## Overview
Backend-first Job Portal application built using Spring Boot with secure authentication, role-based authorization, and REST API architecture. The system allows recruiters to post jobs and users to browse job listings through secured APIs tested using Postman.

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- JPA / Hibernate
- Maven
- REST APIs
- Postman (API Testing)

---

## Features

- User Registration & Login
- JWT-based Authentication & Authorization
- Role-based Access Control (Recruiter / User)
- Secure REST APIs using Spring Security
- Job Posting Functionality for Recruiters
- Job Listing & Fetch APIs for Users
- Input Validation & Exception Handling
- PostgreSQL Database Integration using JPA/Hibernate
- Backend APIs tested using Postman

---

## API Testing

All REST APIs were tested using Postman to verify authentication, authorization, validation, and job management functionalities.

---

## Screenshots

### Authentication - JWT Login

![JWT Login](https://raw.githubusercontent.com/vishal-123coder/jobportal/c7f0d4ac930857f983f8f649a9d2d36e93b05636/screenshots/jobportal_login(JWT%20token).png)

Successful authentication using Spring Security and JWT token generation.

---

### Job Creation API (POST)

![Job Post API](https://raw.githubusercontent.com/vishal-123coder/jobportal/c7f0d4ac930857f983f8f649a9d2d36e93b05636/screenshots/jobportal_job-post(POST).png)

Demonstrates secure job posting functionality with role-based access control.

---

### Job Listing API (GET)

![Job List API](https://raw.githubusercontent.com/vishal-123coder/jobportal/c7f0d4ac930857f983f8f649a9d2d36e93b05636/screenshots/jobportal_jobs(GET)list.png)

Displays all available job listings fetched using REST APIs.

---

### Validation Handling

![Validation Error](https://raw.githubusercontent.com/vishal-123coder/jobportal/c7f0d4ac930857f983f8f649a9d2d36e93b05636/screenshots/jobportal_register(wrong%20data).png)

Input validation and error handling implemented for invalid user registration requests.

---

### Application Running Successfully

![Application Running](https://raw.githubusercontent.com/vishal-123coder/jobportal/c7f0d4ac930857f983f8f649a9d2d36e93b05636/screenshots/jobportal_running.png)

Spring Boot application running successfully with backend services initialized.

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/vishal-123coder/jobportal.git
````

2. Configure PostgreSQL database in `application.properties`

3. Run the Spring Boot application

```bash
mvn spring-boot:run
```

4. Use Postman to test APIs

---

## Future Improvements

* Frontend Integration (React / Thymeleaf)
* Resume Upload Feature
* Job Application Tracking
* Email Notifications
* Admin Dashboard
* Docker Deployment

---

## Author

Vishal Rajput

GitHub: https://github.com/vishal-123coder
LinkedIn: https://linkedin.com/in/vishal-java

```
```
