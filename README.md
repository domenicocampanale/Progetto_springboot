# Spring Boot Application with MySQL Database and MVC Frontend

This application is built using Spring Boot and follows the MVC (Model-View-Controller) architecture. It connects to a MySQL database for data storage of the Entity Libro(Book) and uses an HTML page that shows the entire list of books(libri), as if it was the table from MySQL, through a specified endpoint. The application allows for basic CRUD operations (Create, Read, Update, Delete) on the backend, while the frontend provides an interactive interface to display the data.

Technologies Used:
Spring Boot for the backend (3.4.1).
Java 17.
MySQL for the database.
Thymeleaf as the template engine for the frontend.
Spring Data JPA for interacting with the database.
Log4j2 for logging throughout the code
MapStruct to optimize the implementazion of a Mapper class to convert from Libro(Book) to LibroDto(BookTto) and viceversa or to LibroDtoInput(BookDtoInput that represents the json body for the post and put methods)
