# Smart Inventory & Expiry Tracker

A full-stack web-based inventory management system built with **Java Spring Boot** and **MySQL**, designed to help businesses track stock levels, manage products, and receive real-time alerts for low stock and near-expiry items.

---

 Features

- Product Management — Add, update, view, and delete products (CRUD operations)
- Inventory Tracking — Monitor real-time stock levels across categories
- Smart Alerts — Automated alerts for low stock and near-expiry products
- User Management — Role-based access control for Admin and Staff
- Authentication — Secure login and session management
- REST APIs — Backend exposed via Spring REST for frontend communication

---

 Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java, Spring Boot, Spring MVC, Spring REST |
| Database | MySQL, JDBC, JPA/Hibernate |
| Frontend | HTML5, CSS3, JavaScript, Bootstrap |
| Build Tool | Maven |
| Testing | JUnit, Mockito |
| IDE | Eclipse |

---
 Project Structure

```
smart-inventory-system/
├── Inventory/
│   ├── src/main/java/com/
│   │   ├── controller/        # REST Controllers (Product, Inventory, Alert, Auth)
│   │   ├── model/             # Entity classes (Product, Inventory, Alerts, User)
│   │   ├── repository/        # JPA Repositories for DB operations
│   │   ├── service/           # Business logic layer
│   │   └── smart/Inventory/   # Main Spring Boot Application
│   ├── src/main/resources/
│   │   ├── static/            # Frontend (HTML, CSS, JS)
│   │   └── application.properties
│   └── pom.xml
```

---

 How to Run Locally

Prerequisites
- Java 17+
- MySQL 8.0+
- Maven
- Eclipse IDE / IntelliJ IDEA

### Steps

1. Clone the repository
```bash
git clone https://github.com/roshnib1504/smart-inventory-system.git
```
2. Create MySQL Database
```sql
CREATE DATABASE smartinventory;
```

3. Configure application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smartinventory
spring.datasource.username=root
spring.datasource.password=your_password_here
spring.jpa.hibernate.ddl-auto=update
```

4. Run the application
```bash
cd Inventory
./mvnw spring-boot:run
```

5. Open in browser
```
http://localhost:8083
```

---

 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| POST | `/api/products` | Add new product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |
| GET | `/api/inventory` | Get inventory status |
| GET | `/api/alerts` | Get active alerts |

---

Developer

Priyadarshana Baldota  
Electronics & Telecommunication Engineering — 7th Semester  
GitHub: [@roshnib1504](https://github.com/roshnib1504)
