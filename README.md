# JWT Authentication and Authorization with Spring Boot 

Based on the blog entry Spring Boot [Security Jwt Authentication](https://www.devglan.com/spring-security/spring-boot-jwt-auth) by Dhiraj.

Modernizing the code by
* Use Lombok for model classes
* Changing from MySQL to an embedded H2 database
* Added a CommandLineRunner to initialize the database
* Using @SpringBootTest to call the endpoints

## How to Run
If running in IntelliJ then remember to add the lombok plugin and enable the annotation.

Run from the tests command line
* *mvn clean test*

Run from the application from the command line
* *mvn clean spring-boot:run*
