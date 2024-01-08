# Task Management RESTful API

This project implements a Task Management RESTful API using Java with Spring Boot.

## Features

- CRUD Operations for Tasks (Create, Read, Update, Delete)
- Data Validation and Error Handling
- MySQL Database Integration
- Basic Authentication for API Endpoints

## Setup Instructions

### Prerequisites

- Java JDK (version 8 or higher)
- Maven (for building the project)
- MySQL Database

### Steps to Run the Application

1. **Clone the Repository**

    ```bash
    git clone https://github.com/yourusername/task-management-api.git
    cd task-management-api
    ```

2. **Database Configuration**

    - Create a MySQL database named `task`.
    - For sample data values and tables import this `task_db.sql`
    - Update `application.properties` with your database credentials:
    
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/task_db
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        ```

3. **Run the Application**

    Run the Spring Boot application using Maven:

    ```bash
    mvn spring-boot:run
    ```

4. **Access the API**

    The API will be available at `http://localhost:8080/api/v1`.
    
## API Endpoints

### Tasks

- **GET /tasks** - Get all tasks
- **GET /tasks/{id}** - Get a task by ID
- **GET /tasks/search?title={id}** - Search a task by title
- **POST /tasks** - Create a new task
- **PUT /tasks/{id}** - Update a task
- **DELETE /tasks/{id}** - Delete a task

### Users Login
- **URL:** `/api/v1/user/login`
- **Method:** `POST`
- **Description:** Endpoint for user authentication and token generation.
- **Request Body:**
  ```json
  {
    "username": "example_user",
    "password": "your_password"
  }
  ```
- **Response:**
  ```json
  {
    "token": "generated_token_here"
  }
  ```

### User Registration
- **URL:** `/api/v1/user/register`
- **Method:** `POST`
- **Description:** Endpoint for user registration.
- **Request Body:**
  ```json
  {
    "username": "new_user",
    "password": "new_password",
    "email": "new_email"
  }
  ```
- **Response:**
  ```json
  {
    "username": "registered_username"
    "message": "User registered successfully"
  }
  ```

---

## Security

This application implements security measures to protect endpoints and ensure safe data handling:

### CORS (Cross-Origin Resource Sharing)

- **Configuration:** CORS is configured to restrict or allow cross-origin requests. Modify `CorsConfiguration` to define access rules.

### Basic Authentication

- **Endpoint Protection:** Certain endpoints require basic authentication. Provide valid credentials to access secured endpoints.

### Authorization

- **Access Control:** Authorization rules are applied based on user roles or authorities. Method-level annotations (`@PreAuthorize`, `@Secured`) define access control.

### Additional Security Configurations

- **CSRF Protection:** Automatically enabled to prevent CSRF attacks.
- **Session Management:** Configurations for session handling (e.g., session fixation protection, session timeout settings).
- **Encryption and Hashing:** Passwords and sensitive data are securely encrypted and hashed.

---

## Get in Touch
For inquiries or collaborations, connect with me through 📬:

- Email: [vijaisuria87@gmail.com](mailto:vijaisuria87@gmail.com)
- LinkedIn: [vijaisuria](https://www.linkedin.com/in/vijaisuria/)
- Twitter: [vijaisuria](https://twitter.com/vijaisuria)
- GitHub: [Vijai Suria](https://github.com/vijaisuria)
