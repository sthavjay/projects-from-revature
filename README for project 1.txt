Item Shop Refactor
Description (Due: 04/08/2022)
Project 1 will be divided into two phases, the first one will be a p0 refactor using Spring and the second will be shared later during training.

Both phases will be due on Friday April 8th.

Requirements - Phase 1
Refactor your application and leverage Spring Technologies
Spring Boot
Spring WebMVC
Spring Data JPA

Incorporate User functionality, for example:
As a user, I can login.
As a user, I can register for a customer account.
As an employee, I can add an item to the shop.
As a customer, I can view the available items.
As a customer, I can purchase an item.
As an employee, I can remove an item from the shop.
As a customer, I can view the items that I own.
Logging and Testing

Phase 1 bonus
Be creative and incorporate other topics into your project, they do not have to have been covered by our curriculum. Here are some suggestions:

Mocking (Mockito)
Password hashing
JWT
MockMvc (Testing the web layer)

Requirements - Phase 2
Containerize your application and a database instance using Docker and Docker Compose.
Log your application thoroughly using MDC
create a custom pattern
try leveraging different logging levels
Log aggregation using Promtail, Loki, Grafana


Technologies Used:
* Spring Boot
* Maven
* Spring MVC
* Prostgres using AWS postgresQL database
* Promtail, Loki, Prometheus and Grafana
* Docker and Docker-compose
* Postman and Restful API
* Hibernate and logback-spring
* Exceptions

Features:
* abled to use https verbs like get, post and pull for http request and respone.
* abled to record the log and metrics in seperate application.log using logback spring configuration.
* abled to display the log and metrics charts and table in Grafana using promtail, loki and prometheus.
* abled to use different types dependencies using Maven tools.
* abled to use containerized applications using docker and docker-compose.
* abled to use postgreSQL database using data.sql file.

useable Commands
-> docker build -t proj
-> docker run -it proj
-> docker-compose up -d
-> docker logs 
-> docker-compose down


local host urls:
-> localhost:8080/   (for API)
-> localhost:3000  (for grafana)
-> localhost:8081/actuator (for prometheus)
-> localhost:3101/conf  (for promtail)



