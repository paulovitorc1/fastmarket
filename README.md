📌 FAST MARKET - SYSTEM DOCUMENTATION
=====================================

🚀 Overview
-----------

FAST MARKET is a system designed to facilitate inventory management and sales tracking for businesses. This project integrates modern technologies to provide a robust and scalable solution.

📦 Tech Stack
-------------

The following technologies are used in this project:

-   **Java 17**: Backend development
-   **Spring Boot**: Framework for backend logic
-   **Spring Security & JWT**: Authentication and security
-   **Spring Data JPA**: Database ORM management
-   **PostgreSQL**: Relational database
-   **REST API**: Communication standard
-   **Angular 12**: Frontend development
-   **Bootstrap**: UI framework for responsive design
-   **Java EE Architecture**: Enterprise-level application structure

⚙️ Features
-----------

-   🔐 **User Authentication** (JWT & Spring Security)
-   📦 **Product and Inventory Management**
-   📊 **Order and Sales Tracking**
-   📜 **Invoice Management**
-   📍 **Order Status & Shipping Tracking**
-   📂 **Data Persistence with PostgreSQL**
-   🔄 **REST API for Integration**
-   📱 **Responsive UI with Angular & Bootstrap**

🎯 Functional Requirements
--------------------------

-   Users can register and log in securely.
-   Admins can add, update, and delete products.
-   Customers can browse products and place orders.
-   Orders have statuses (e.g., pending, shipped, delivered).
-   System generates invoices automatically.
-   Users can track order history.
-   Admins can view sales analytics.

🏗️ Installation & Setup
------------------------

### Prerequisites:

-   Java 17
-   PostgreSQL
-   Node.js (for Angular frontend)

### Backend Setup:

1.  Clone the repository:

    ```
    git clone https://github.com/your-repo/fast-market.git

    ```

2.  Navigate to the backend directory:

    ```
    cd backend

    ```

3.  Install dependencies and run the application:

    ```
    mvn spring-boot:run

    ```

### Frontend Setup:

1.  Navigate to the frontend directory:

    ```
    cd frontend

    ```

2.  Install dependencies:

    ```
    npm install

    ```

3.  Start the Angular application:

    ```
    ng serve

    ```

🚀 API Endpoints
----------------

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/products` | List all products |
| POST | `/products` | Add a new product |
| PUT | `/products/{id}` | Update product details |
| DELETE | `/products/{id}` | Delete a product |
| POST | `/auth/login` | Authenticate user |
| GET | `/orders` | List all orders |

🛠️ Contributors
----------------

-   **Paulo Lima** - Developer

📜 License
----------

This project is licensed under the MIT License.

* * * * *

🚀 Happy Coding! Let me know if you need any improvements.