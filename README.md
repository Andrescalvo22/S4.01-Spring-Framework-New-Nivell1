## 🧩 User Management API

## 📄 Description - Exercise Statement

This project is a Spring Boot REST API for managing users.
It allows creating, retrieving, and filtering users by name.
The goal was to create a user management system that supports adding, listing, and retrieving users through HTTP endpoints, while gradually applying best practices in software architecture and testing.

---

## 💻 Technologies Used

-Java 17

-Spring Boot 3.x

-Spring Web

-Spring Data JPA

-H2 Database (in-memory database)

-Maven (dependency management)

-JUnit 5 & MockMvc (testing)

---

## 📋 Requirements

Before running the project, make sure you have:

-Java JDK 17 or higher installed

-Maven 3.8+ installed

-Internet connection to download dependencies

-(Optional) Postman or any API testing tool

## 🛠️ Installation

Clone the repository:
```bash

git clone https://github.com/your-username/user-api.git
```

Navigate to the project directory:
```bash

cd user-api

```
Install dependencies:

```bash

mvn clean install
```
## ▶️ Execution

To run the application locally:

```bash

mvn spring-boot:run

```
Then open your browser or API client and go to:
👉 http://localhost:8080/users

Example Endpoints
Method	Endpoint	Description
GET	/users	Returns all users
GET	/users/{id}	Returns a user by ID
POST	/users	Creates a new user
GET	/users?name={name}	Filters users by name

---

## 🌐 Deployment

To deploy to production:

Package the application:

```bash

mvn package

```
Run the JAR file:

```bash

java -jar target/user-api-0.0.1-SNAPSHOT.jar

```
You can deploy it to any Java-supported server (e.g., AWS, Azure, Heroku, or a local VPS).

---

## 🤝 Contributions

Contributions are welcome!
If you want to improve this project:

-Fork the repository

-Create a new branch (feature/your-feature-name)

-Commit your changes

-Open a Pull Request
