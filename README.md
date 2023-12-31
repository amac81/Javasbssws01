# Web services with Spring Boot, Spring Security and JPA / Hibernate / MySQL 

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/amac81/Javasbssws01/blob/main/LICENSE) 

# About the project

Javasbssws01 it's a Project developed with learned contents of The Complete Java 2023 - Object Oriented Programming + Projects and Spring Boot 3: Learn Spring 6, Spring Core, Spring REST, Spring MVC, Spring Security, Thymeleaf, JPA, Hibernate, MySQL courses.

##  Its objectives:

- Create a Spring Boot Java project;
- Implement the domain model;
- Structuring the application in logical layers: resource, service, repository;
- Configure and use the MySQL database;
- Populate the database with test data(seed);
- CRUD - Create, Retrieve, Update, Delete;
- Handling exceptions;
- Configuring and implementing Spring Security.

## Conceptual model
![Modelo Conceitual](https://github.com/amac81/Javasbssws01/blob/main/assets/raw/conceptual_model.png)

# Technologies used
## Back end
- Java
- Spring Boot
- Spring Security
- MySql
- Maven
- Apache Tomcat
- Heroku

# Patterns used
- Layers pattern

# How to run the project

## Back end
Prerequisites: 
  - Java 17;
  - MySQL database server;

```bash
# clone repository
git clone https://github.com/amac81/Javasbssws01.git

# run the project
./mvnw spring-boot:run (Linux, OSX, Solaris)

mvnw.cmd spring-boot:run (Windows)
```

# How to test the project

Prerequisites: 
  - Postman or Internet Browser;

### Endpoint for clients

```bash

Examples:

# GET clients

http://localhost:8080/api/clients

# GET client by Id

http://localhost:8080/api/clients/2

# POST client

http://localhost:8080/api/clients

body
{
    "name": "Maria Betania",
    "email": "maryb@mail.com",
    "phone": "222322332"    
}

# DELETE client (by Id)

http://localhost:8080/api/clients/2

# PUT client (update client by Id)

http://localhost:8080/api/clients

body:
{
    "name": "Ava Apple",
    "email": "avaaple@mail.com",
    "phone": "12234223"
}
```

### Endpoint for orders

```bash

Examples:

# GET orders

http://localhost:8080/api/orders

# GET order by Id

http://localhost:8080/api/orders/3

# POST order

http://localhost:8080/api/orders

body
{
    "moment": "2023-07-26T12:09:22Z",
    "orderStatus": "WAITING_PAYMENT",
    "client": {
            "id": 1           
     }
}

# DELETE order (by Id)

http://localhost:8080/api/orders/4


# PUT order (update order by Id)

http://localhost:8080/api/orders

body
{
    "moment": "2023-07-26T12:09:22Z",
    "orderStatus": "CANCELED",
    "client": {
            "id": 2           
     }
}

```

### Endpoint for products

```bash

Examples:

# GET products

http://localhost:8080/api/products

# GET product by Id

http://localhost:8080/api/products/3

# POST product

http://localhost:8080/api/products

body
{
    "name": "Bicicleta SCOTT CONTESSA SPEEDSTER 25 DISC",
    "description": "A SCOTT Contessa Speedster 25 é uma leve, ágil e acessível bicicleta de estrada em alumínio. Com cabos totalmente integrados, esta bicicleta não só anda bem, como tem uma aparência espetacular!",
    "price": "37.22",
    "imgUrl": "http://wwww.bitclinic.pt/products/img8.jpg"
}

# DELETE product (by Id)

http://localhost:8080/api/products/1

# PUT product (update product by Id)

http://localhost:8080/api/products

body
{
    "name": "Bicicleta de Estrada SCOTT",
    "description": "A SCOTT Contessa Speedster 25 é uma leve, ágil e acessível bicicleta de estrada em alumínio. Com cabos totalmente integrados, esta bicicleta não só anda bem, como tem uma aparência espetacular!",
    "price": "3437.22",
    "imgUrl": "http://wwww.bitclinic.pt/products/img8.jpg"
}

```

### Endpoint for categories

```bash

Examples:

# GET categories

http://localhost:8080/api/categories

# GET category by Id

http://localhost:8080/api/categories/3

# POST category

http://localhost:8080/api/categories

body
{
    "name": "Health and Beauty"
}

# DELETE category (by Id)
http://localhost:8080/api/categories/2

# PUT category (update category by Id)

http://localhost:8080/api/categories

body
{
    "name": "Toys and Games"
}

```

# Author

Arnaldo Manuel de Almeida Canelas

https://www.linkedin.com/in/arnaldocanelas
