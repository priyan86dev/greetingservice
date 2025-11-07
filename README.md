# Greeting Service
This project serves as a demonstration of a simple **RESTful API**, showcasing request handling, service-layer logic, and structured responses.
## Tech Stack
`1.` Java 17+ <br>
`2.` Spring Boot 3.5.7 <br>
`3.` Build Tool Maven <br>
`4.` Testing Junit5 + Mockito <br>
## Instructions
### Running the Application
#### Using Maven
 `mvn spring-boot:run`
   
#### Using IntelliJ IDEA
`1.` Open the project.<br>
`2.`Let Maven import dependencies.<br>
`3.` Run GreetingServiceApplication.java

### Running the Tests
##### Using Maven
`mvn test`

### API End Point
#### Request
`GET /hello-world?name=alice`

#### Response
`{
"message": "Hello Alice"
}`

