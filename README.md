# JWT Authentication and Authorization with Spring Boot 

Based on the blog entry Spring Boot [Security Jwt Authentication](https://www.devglan.com/spring-security/spring-boot-jwt-auth) by Dhiraj.

Modernizing the code by
* Changing from MySQL to an embedded H2 database
* Added a CommandLineRunner to initialize the database
* Using @SpringBootTest to call the endpoints