# Spring MVC REST + Java REST Client

🌐📊 RESTful CRUD Application for Employee Management

This is a classic Spring MVC (non-Spring Boot) REST application for managing employees, accompanied by a standalone Java REST client.

The server exposes a REST API for performing Create, Read, Update and Delete (CRUD) operations on employees.
All data is persisted in a MySQL database using Hibernate ORM.

The client application consumes the REST API directly (without a browser UI) and demonstrates programmatic interaction with a Spring-based backend.

## 📌 Project Overview

The project consists of two independent applications located in a single repository:

Server — Spring MVC REST API deployed on Apache Tomcat

Client — Java application that communicates with the REST API via HTTP

The server follows a classic layered architecture:

Controller → Service → DAO → Entity

## ✨ Features
  Server (REST API)
- Full CRUD operations for employees (Create, Read, Update, Delete)
- RESTful endpoints built with Spring MVC
- JSON-based data exchange
- Persistence layer implemented with Hibernate ORM
- DAO pattern for database access
- Global exception handling for REST responses
- MySQL database integration
- Deployed as a WAR to Apache Tomcat

  Client (Java Application)
- Standalone Java REST client
- Communicates with the server via HTTP
- Uses Spring RestTemplate
- Demonstrates consuming REST endpoints programmatically

## Screenshots

### Employee List
![Employee List](images/Screenshot.png)

## 🧩 Project Structure

spring_course_rest
├── server → Spring MVC REST API (WAR, Tomcat)
└── client → Java REST client (JAR)

## 🛠 Requirements

- ☕ Java 8 or higher
- 📦 Maven
- 🐬 MySQL 8.x
- 🐱 Apache Tomcat 9.x
- 💡 IntelliJ IDEA (recommended)

## 🚀 How to Run

### 1️⃣ Clone the repository

Clone this repository to your local machine:
```bash
git clone [https://github.com/your-username/spring-course-rest.git](https://github.com/Nabuchodon0ssor/Spring-MVC-REST-API)
```

Or download it as a ZIP archive and extract it.

### 2️⃣ Open the project in IntelliJ IDEA

- Open IntelliJ IDEA
- Select File → Open
- Choose the root project folder spring_course_rest
- IntelliJ will automatically detect two Maven modules
- Make sure all Maven dependencies are downloaded successfully

### 3️⃣ Install and configure MySQL

Make sure **MySQL is installed and running** on your computer.

- MySQL version: **8.x**
- Default port: **3306**

You can check MySQL installation by running:

```bash
mysql --version
```

Or by opening MySQL Workbench.

### 4️⃣ Create a local database

Open MySQL Workbench (or terminal) and run:

```sql
CREATE DATABASE my_db;
USE my_db;
```
Create table
```sql
CREATE TABLE employees (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(15),
  surname VARCHAR(25),
  department VARCHAR(20),
  salary INT,
  PRIMARY KEY (id)
);
```
(Optional) Add test data
```sql
INSERT INTO employees (name, surname, department, salary) VALUES
('Lucas', 'Neumann', 'IT', 1200),
('Sophie', 'Keller', 'HR', 900),
('Maria', 'Klein', 'Sales', 950);
```

✅ Database is ready.


### 5️⃣ Configure database credentials (Server)

Open the configuration class:

```markdown
spring_course_rest/server/src/main/java/com/dimapasunkov/spring/rest/configuration/MyConfig.java
```

Find the DataSource configuration:


```java
@Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false");
            dataSource.setUser("bestuser");
            dataSource.setPassword("bestuser");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
```

You can change the following properties if needed:

setJdbcUrl → database name and connection URL

setUser → MySQL username

setPassword → MySQL password


Make sure the database name matches the one created in MySQL.




### 6️⃣ Run the Server (REST API)

This is a classic Spring MVC application, so it must be deployed to Apache Tomcat.
Steps in IntelliJ IDEA:
- Run → Edit Configurations
- Add Tomcat Server → Local
- Configure Tomcat installation directory

Deployment:
- Add artifact: spring-course-rest-server:war exploded
- Application context: /spring_course_rest
- Start the server

REST API base URL:
```markdown
http://localhost:8080/spring_course_rest/api/employees
```

### 7️⃣ Run the Client

- Make sure the Tomcat server is running
- Locate the App class in the client module
  \spring_course_rest\client\src\main\java\com\dimapasunkov\spring\rest\App.java
- Run App as a Java Application
- The client sends HTTP requests to the REST API and prints results to the console.

### ℹ️ Important Notes

- The database is not included in the repository
- Each developer creates the database locally
- The server and client are independent applications
- No Spring Boot is used — configuration is fully manual

This project was built as a learning and portfolio project to demonstrate classic Spring MVC REST architecture, layered design, and client–server interaction in Java.
