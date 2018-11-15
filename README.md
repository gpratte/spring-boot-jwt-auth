# JWT Authentication and Authorization with Spring Boot 

Based on the blog entry Spring Boot [Security Jwt Authentication](https://www.devglan.com/spring-security/spring-boot-jwt-auth) by Dhiraj.

Modernizing the code by
* It compiles!
* Use Lombok for model classes
* Changing from MySQL to an embedded H2 database
* Added a CommandLineRunner to initialize the database
* Using @SpringBootTest to call the endpoints

## Maven
Make sure you have maven installed.

To check run the following from the command line
* *mvn --version*
You should see something starting with _Apache Maven_ and a lot more output.

## IntelliJ
If running in IntelliJ then remember to add the lombok plugin and enable the annotation.

## How to Run the tests
Run from the tests from the command line
* *mvn clean test*

## How to Run the server
Run from the application from the command line
* *mvn clean spring-boot:run*

## curl
There is a curl folder that has a curl command to call the generate token endpoint.