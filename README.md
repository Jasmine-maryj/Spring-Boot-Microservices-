# Microservices with Spring Boot

This repository contains a microservices architecture implemented using Spring Boot. The architecture includes several microservices responsible for different aspects of an e-commerce application: Order service, Inventory service, Product service, User service, Discovery server, and API gateway.

## Table of Contents

- [Getting Started](#getting-started)
- [Architecture Overview](#architecture-overview)
- [Services](#services)
- [Setup and Configuration](#setup-and-configuration)
- [Usage](#usage)

## Getting Started

Before you begin, make sure you have the following prerequisites:
- Java Development Kit (JDK) 8+
- Maven for building the project

## Architecture Overview

The microservices architecture is designed to promote the application's modularity, scalability, and maintainability. Here's a brief overview of the components:

- **Order service**: Manages customer orders and order-related operations.
- **Inventory service**: Handles inventory management and stock-related operations.
- **Product service**: Manages product information and related functionalities.
- **User service**: Manages user accounts, authentication, and user-related operations.
- **Discovery server**: Implements service discovery and registration using Netflix Eureka.
- **API gateway**: Acts as the entry point for external requests and routes them to the appropriate microservices.
- **Distributed Tracing**: Incorporates distributed tracing for monitoring and debugging.

## Services

### Order Service

- Endpoint: `/orders`
- Manages customer orders and provides operations like creating, updating, and retrieving orders.

### Inventory Service

- Endpoint: `/inventory`
- Manages inventory information and provides operations like checking stock availability.

### Product Service

- Endpoint: `/products`
- Manages product details and provides operations to retrieve product information.

### User Service

- Endpoint: `/users`
- Handles user-related operations, authentication, and account management.

### Discovery Server

- Endpoint: `/eureka`
- Service discovery server that allows microservices to register and discover each other.

### API Gateway

- Endpoint: `/api`
- Acts as a single entry point for external requests and routes them to the respective services.

### Distributed Tracing

- Incorporates using micrometer/zipkin. This enables end-to-end tracing of requests across microservices.

## Setup and Configuration

To run the microservices locally, follow these steps:

1. Clone this repository.
2. Navigate to each service's directory and run `mvn spring-boot:run` to start each microservice.
3. Start the Discovery server and API Gateway before the other services are running.
4. Set up the Micrometer/Zipkin agent in each microservice for distributed tracing.

Make sure you have Java and Maven installed on your system.

## Usage

- Access the services through the API Gateway at `http://localhost:8080/api/v1/{service-name}`.
- Use the Eureka dashboard to monitor registered services at `http://localhost:8761/eureka`.

