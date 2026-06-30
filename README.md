# 💈 Microservices Barber Shop

A full-stack microservices-based barbershop management system built with Spring Boot and React. This project demonstrates modern microservices architecture patterns including service discovery, API gateway, and distributed services.

## 📋 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Services](#services)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Security Notice](#security-notice)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This application provides a complete barbershop management solution with the following features:

- **User Management**: Authentication and authorization with Spring Security
- **Service Catalog**: Browse available barbershop services and masters
- **Booking System**: Schedule and manage appointments
- **Schedule Management**: Handle barber availability and working hours
- **Feedback System**: Customer reviews and ratings
- **API Gateway**: Unified entry point for all microservices
- **Service Discovery**: Automatic service registration and discovery using Netflix Eureka

## 🏗️ Architecture

This project follows a microservices architecture pattern with the following components:

```
┌─────────────┐
│   Client    │
│  (React)    │
└──────┬──────┘
       │
       ▼
┌─────────────────────────────┐
│      API Gateway            │
│   (Spring Cloud Gateway)    │
│    Port: Default            │
└──────────┬──────────────────┘
           │
           ├──────────┬──────────┬──────────┬──────────┬──────────┐
           │          │          │          │          │          │
           ▼          ▼          ▼          ▼          ▼          ▼
    ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐
    │  User    │ │ Catalog  │ │ Booking  │ │Schedule  │ │Feedback  │
    │ Service  │ │ Service  │ │ Service  │ │ Service  │ │ Service  │
    │ :8081    │ │ :8084    │ │ :8085    │ │ :8082    │ │ :8083    │
    └────┬─────┘ └────┬─────┘ └────┬─────┘ └────┬─────┘ └────┬─────┘
         │            │            │            │            │
         ▼            ▼            ▼            ▼            ▼
    ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌──────────┐
    │PostgreSQL│ │PostgreSQL│ │PostgreSQL│ │PostgreSQL│ │PostgreSQL│
    │   DB     │ │   DB     │ │   DB     │ │   DB     │ │   DB     │
    └──────────┘ └──────────┘ └──────────┘ └──────────┘ └──────────┘
           │          │          │          │          │
           └──────────┴──────────┴──────────┴──────────┘
                              │
                              ▼
                    ┌──────────────────┐
                    │ Discovery Server │
                    │   (Eureka)       │
                    │    Port: 8761    │
                    └──────────────────┘
```

### Architecture Patterns Used

- **Service Discovery**: Netflix Eureka for automatic service registration and discovery
- **API Gateway**: Spring Cloud Gateway for routing and load balancing
- **Database per Service**: Each microservice has its own PostgreSQL database
- **OAuth2 Authentication**: Centralized authentication via Keycloak
- **RESTful APIs**: Standard HTTP/REST communication between services

## 🛠️ Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.0.6**
- **Spring Cloud 2022.0.2**
  - Spring Cloud Gateway
  - Netflix Eureka (Service Discovery)
- **Spring Security with OAuth2**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Lombok**
- **Maven**

### Frontend
- **React 18.2.0**
- **React Scripts 5.0.1**
- **JavaScript/JSX**

### Infrastructure
- **Keycloak** (OAuth2/OpenID Connect provider)
- **PostgreSQL** (Database)
- **Maven** (Build tool)

## 🔧 Services

### 1. Discovery Server (Port: 8761)
- **Purpose**: Service registry for microservices discovery
- **Technology**: Netflix Eureka Server
- **Key Features**:
  - Automatic service registration
  - Service health monitoring
  - Load balancing support

### 2. API Gateway
- **Purpose**: Single entry point for all client requests
- **Technology**: Spring Cloud Gateway
- **Key Features**:
  - Request routing
  - OAuth2 authentication
  - Load balancing
  - CORS configuration

### 3. User Service (Port: 8081)
- **Purpose**: User authentication and management
- **Database**: user-service PostgreSQL
- **Key Features**:
  - User registration
  - Authentication/Authorization
  - User profile management
  - Spring Security integration

### 4. Catalog Service (Port: 8084)
- **Purpose**: Manage barbershop services and masters
- **Database**: catalog-service PostgreSQL
- **Key Features**:
  - Service CRUD operations
  - Master/Barber management
  - Service catalog browsing

### 5. Booking Service (Port: 8085)
- **Purpose**: Handle appointment bookings
- **Database**: booking-service PostgreSQL
- **Key Features**:
  - Create/update/cancel bookings
  - Booking history
  - Availability checking

### 6. Schedule Service (Port: 8082)
- **Purpose**: Manage barber schedules and availability
- **Database**: schedule-service PostgreSQL
- **Key Features**:
  - Working hours management
  - Schedule availability
  - Time slot management

### 7. Feedback Service (Port: 8083)
- **Purpose**: Customer reviews and ratings
- **Database**: feedback-service PostgreSQL
- **Key Features**:
  - Submit reviews
  - Rating system
  - Feedback management

### 8. Frontend (Port: 3000)
- **Purpose**: React-based user interface
- **Technology**: React 18
- **Status**: Basic setup (ready for development)

## 🚀 Getting Started

### Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 17** or higher
- **Maven 3.6+**
- **Node.js 16+** and **npm**
- **PostgreSQL 12+**
- **Keycloak Server** (for OAuth2 authentication)
- **Git**

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/microservices-barber-shop.git
   cd microservices-barber-shop
   ```

2. **Set up PostgreSQL databases**

   Create the following databases:
   ```sql
   CREATE DATABASE "user-service";
   CREATE DATABASE "catalog-service";
   CREATE DATABASE "booking-service";
   CREATE DATABASE "schedule-service";
   CREATE DATABASE "feedback-service";
   ```

3. **Configure Keycloak**

   - Install and run Keycloak server on port 8181
   - Create a realm named: `spring-boot-microservices-barber-shop-realm`
   - Configure OAuth2 clients for the services
   - Update the issuer URI in `api-gateway/src/main/resources/application.yml` if needed

4. **Update application configurations**

   ⚠️ **Important**: The configuration files contain default development credentials. For production use, replace these with environment variables:

   ```yaml
   # Example: In each service's application.yml
   spring:
     datasource:
       username: ${DB_USERNAME:postgres}
       password: ${DB_PASSWORD:postgres}
   ```

### Running the Application

#### Option 1: Run all services using Maven (from parent directory)

```bash
# Build all services
cd microservices-barber-shop
mvn clean install

# Run services in separate terminals:

# Terminal 1 - Discovery Server
cd discovery-server
mvn spring-boot:run

# Terminal 2 - API Gateway (wait for Discovery Server to start)
cd api-gateway
mvn spring-boot:run

# Terminal 3 - User Service
cd user-service
mvn spring-boot:run

# Terminal 4 - Catalog Service
cd catalog-service
mvn spring-boot:run

# Terminal 5 - Booking Service
cd booking-service
mvn spring-boot:run

# Terminal 6 - Schedule Service
cd schedule-service
mvn spring-boot:run

# Terminal 7 - Feedback Service
cd feedback-service
mvn spring-boot:run
```

#### Option 2: Run individual services

```bash
cd microservices-barber-shop/<service-name>
./mvnw spring-boot:run
```

#### Running the Frontend

```bash
cd microservices-barber-shop-frontend
npm install
npm start
```

The frontend will be available at `http://localhost:3000`

### Startup Order

For proper initialization, start the services in this order:

1. **PostgreSQL** (ensure all databases are running)
2. **Keycloak Server** (port 8181)
3. **Discovery Server** (port 8761)
4. **API Gateway** (after Discovery Server is ready)
5. **Business Services** (user, catalog, booking, schedule, feedback - can start in parallel)
6. **Frontend** (after all backend services are running)

## 📚 API Documentation

### Service Endpoints

Access the Eureka Dashboard to view all registered services:
- **Eureka Dashboard**: `http://localhost:8761`

### Example API Endpoints (via API Gateway)

#### User Service
- `POST /api/users` - Register a new user
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

#### Catalog Service
- `GET /api/services` - Get all services
- `POST /api/services` - Create a new service
- `GET /api/masters` - Get all masters
- `POST /api/masters` - Create a new master

#### Booking Service
- `GET /api/bookings` - Get all bookings
- `POST /api/bookings` - Create a new booking
- `PUT /api/bookings/{id}` - Update booking
- `DELETE /api/bookings/{id}` - Cancel booking

#### Schedule Service
- `GET /api/schedules` - Get all schedules
- `POST /api/schedules` - Create a schedule
- `GET /api/schedules/{masterId}` - Get schedule by master

#### Feedback Service
- `GET /api/feedbacks` - Get all feedbacks
- `POST /api/feedbacks` - Submit feedback
- `GET /api/feedbacks/{id}` - Get feedback by ID

## 🔒 Security Notice

⚠️ **IMPORTANT SECURITY NOTICE**: This project contains hardcoded credentials for development purposes only. These credentials are:

- **PostgreSQL**: username: `postgres`, password: `postgres`
- **Eureka**: username: `eureka`, password: `password`

**Before deploying to production or making this repository public, you MUST:**

1. Replace all hardcoded credentials with environment variables
2. Use a secrets management solution (e.g., HashiCorp Vault, AWS Secrets Manager)
3. Implement proper OAuth2 configuration with real Keycloak setup
4. Enable HTTPS/TLS for all services
5. Review and implement additional security best practices

### Recommended: Using Environment Variables

Create a `.env` file (add to `.gitignore`):

```env
DB_USERNAME=your_username
DB_PASSWORD=your_password
EUREKA_USERNAME=your_eureka_username
EUREKA_PASSWORD=your_eureka_password
```

## 📁 Project Structure

```
microservices-barber-shop/
├── microservices-barber-shop/          # Backend microservices
│   ├── api-gateway/                    # API Gateway service
│   ├── discovery-server/               # Eureka server
│   ├── user-service/                   # User management service
│   ├── catalog-service/                # Catalog management service
│   ├── booking-service/                # Booking management service
│   ├── schedule-service/               # Schedule management service
│   ├── feedback-service/               # Feedback management service
│   └── pom.xml                         # Parent POM
├── microservices-barber-shop-frontend/ # React frontend application
│   ├── public/                         # Public assets
│   ├── src/                            # React source code
│   └── package.json                    # NPM dependencies
├── .gitignore                          # Git ignore rules
└── README.md                           # This file
```

### Service Structure (Example)

```
service-name/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/diploma/servicename/
│   │   │       ├── controller/       # REST controllers
│   │   │       ├── service/          # Business logic
│   │   │       ├── repository/       # Data access layer
│   │   │       ├── model/            # Entity models
│   │   │       ├── dto/              # Data transfer objects
│   │   │       └── exception/        # Custom exceptions
│   │   └── resources/
│   │       └── application.yml       # Configuration
│   └── test/                          # Unit and integration tests
├── pom.xml                            # Maven configuration
└── README.md                          # Service-specific documentation
```

## 🤝 Contributing

This is a portfolio/demonstration project, but suggestions and feedback are welcome!

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is created for educational and portfolio purposes.

## 👨‍💻 Author

Created as a diploma/portfolio project demonstrating microservices architecture with Spring Boot and React.

## 🔮 Future Enhancements

Potential improvements for this project:

- [ ] Complete React frontend implementation
- [ ] Add Docker and Docker Compose support
- [ ] Implement centralized configuration with Spring Cloud Config
- [ ] Add distributed tracing with Zipkin/Sleuth
- [ ] Implement circuit breaker pattern with Resilience4j
- [ ] Add comprehensive API documentation with Swagger/OpenAPI
- [ ] Implement event-driven communication with RabbitMQ/Kafka
- [ ] Add monitoring with Prometheus and Grafana
- [ ] Implement comprehensive integration tests
- [ ] Add CI/CD pipeline (GitHub Actions/Jenkins)
- [ ] Kubernetes deployment configurations

## 📞 Support

For questions or issues, please open an issue in the GitHub repository.

---

**Note**: This is a demonstration project showcasing microservices architecture patterns and modern Spring Boot development practices.
