# 🪑 FurnitureX - Full Stack Furniture E-Commerce Website

FurnitureX is a full-stack e-commerce web application for selling furniture products. The project features user and admin login systems, product listings, CRUD operations, a payment gateway integration, order history tracking, and wishlist management. It is built using Java, Spring Boot, Hibernate, MySQL, and Thymeleaf for dynamic HTML rendering.

---

## 🚀 Tech Stack

- **Frontend:** HTML, CSS, JavaScript, Thymeleaf
- **Backend:** Java, Spring Boot, Spring MVC, Hibernate
- **Database:** MySQL
- **Build Tool:** Maven

---

## 🔑 Features

- ✅ User/Admin-based authentication system
- 🛒 Product listing and categorization
- 🔍 Search and filter products by category
- ❤️ Wishlist management
- 🧾 Order history for users
- 🧰 Admin dashboard with full CRUD operations
- 💳 Payment gateway integration (mock/real)
- 📦 Real-time cart and checkout flow

---

## ⚙️ Installation Guide

### Prerequisites

- Java JDK 17+
- MySQL Server
- Maven
- IDE (Eclipse, IntelliJ IDEA, VS Code)

---

## 🖥️ Project Structure

```bash
FurnitureX/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.furniturex/       # Java source files (Controllers, Services, Repositories)
│   │   ├── resources/
│   │   │   ├── templates/            # Thymeleaf HTML templates
│   │   │   ├── static/               # Static files (CSS, JS)
│   │   │   └── application.properties
├── pom.xml                          # Maven dependencies
└── README.md
```
---

### 🔧 Step-by-Step Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/HAJ1MEI/FurnitureX.git
   cd FurnitureX
   
2. **Create a MySQL Database**
   Open your MySQL client (like MySQL Workbench or phpMyAdmin) and run:
     ```bash 
     CREATE DATABASE furniturex;

3. **Insert Sample Data**
    Manually add sample data for:
    - Products
    - Categories
    - Users/Admin

4. **Configure application.properties**
    Navigate to src/main/resources/application.properties and update:
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/furniturex
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

### 🛠️ Future Improvements
 - REST APIs for frontend/backend separation
 - Product ratings & reviews
 - Email notifications
 - Fully responsive design
 - Image upload and cloud storage integration

### 📄 License
  This project is licensed under the MIT License. See the LICENSE file for details.

### 🤝 Acknowledgements
  - Spring Boot Documentation
  - Thymeleaf Templates
  - MySQL Workbench
  - Bootstrap CSS

### 💬 Contact
Developed by HAJ1MEI
For any queries: vhatkarprash824@gmail.com

   
