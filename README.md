# Student Management System

A web-based Student Management System developed using Java, Spring Boot, Thymeleaf, Spring Security, and MySQL.

## Features

- Admin Signup and Login
- Secure Password Encryption using BCrypt
- Add New Students
- View Student Records
- Edit Student Details
- Delete Student Records
- Dashboard with Student Count
- MySQL Database Integration

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Thymeleaf
- MySQL
- HTML
- CSS
- Maven

## Project Structure

```text
src
 └── main
     ├── java
     │   └── com.anuradha/student_management
     │       ├── config
     │       ├── model
     │       ├── repository
     │       ├── AdminController.java
     │       ├── StudentController.java
     │       └── StudentManagementApplication.java
     └── resources
         └── templates
             ├── dashboard.html
             ├── edit.html
             ├── index.html
             ├── login.html
             └── signup.html
```

## How to Run

1. Clone this repository.
2. Open the project in VS Code or IntelliJ IDEA.
3. Create a MySQL database named `student_management`.
4. Configure your local database credentials in `application.properties`.
5. Run the application using:

```bash
mvn spring-boot:run
```

6. Open your browser and visit:

```text
http://localhost:8080
```

## Author

Anuradha Thakur

## License

This project is available for educational purposes.