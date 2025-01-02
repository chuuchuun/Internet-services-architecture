Java SE Laboratory 1

This project focuses on developing a Java SE application to explore fundamental programming concepts such as object relationships (1:N), entity classes, and the builder pattern. 
Key features include using Stream API for collection operations, serialization for data persistence, and multi-threading with custom thread pools. 
The application is built as an Apache Maven project, with Project Lombok support.

Spring Framework & Spring Boot Laboratory 2

This project introduces the Spring Framework and Spring Boot, focusing on dependency injection, inversion of control, and Spring Data for database interactions. 
Tasks include enhancing JPA-annotated entity classes, implementing repositories and services, initializing example data, and creating a command-line interface for basic CRUD operations. 
The application is built as a Maven Spring Boot project, using H2 as the in-memory database.

Spring MVC Laboratory 3

This project focuses on Spring MVC for implementing RESTful services. 
Tasks include creating DTOs for CRUD operations, building REST controllers for entities, and ensuring proper HTTP methods, response codes, and hierarchical resource addresses. 
Additional features include cascading deletes for related entities and comprehensive HTTP request documentation using request.http. 
The application builds upon previous labs and follows best practices for REST API design.

Microservices Architecture Laboratory 4

This lab introduces microservices architecture by decomposing a monolithic Spring Boot application into two standalone services: one for category management and another for elements management. 
Tasks include implementing inter-application event-based communication using REST and creating a Spring Cloud Gateway application for centralized routing. 
Each service uses its private in-memory H2 database while maintaining consistency through event synchronization.

Angular Framework Laboratory 5

This lab focuses on building a web application using the Angular Framework to interact with the previously developed microservices gateway. 
Tasks include creating views for listing, adding, editing, and viewing details of categories and elements, leveraging Angular's routing module. 
The application implements dynamic path parameters for seamless navigation and CRUD operations, ensuring an intuitive user interface for managing categories and their associated elements.
