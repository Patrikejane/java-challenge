### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

#### Your experience in Java

Please let us know more about your Java experience in a few sentences. For example:

- I have 3 years experience in Java and I started to use Spring Boot from last year
- I'm a beginner and just recently learned Spring Boot
- I know Spring Boot very well and have been using it for many years

################################################################################################

#### what you did:
- update the Spring Boot version in order to mitigate direct vulnerabilities
- Add role base security layer 
- Implement caching with Spring Cache
- Added ControllerAdvisor to centralize exception handling for reporting validation errors
- added loggers for meaning full logging purpose 
- Refactor Code Format and annotations
- Added tests (controller test)
- added environment profiles to separate between dev test prod.

#### what you would have done
further  improvements:

- Sprig 3 and Java latest:
in order to mitigate vulnerabilities of previous Versions

- User Authentication: 
Implement user authentication/authorization using oAuth2/OpenIDconnet to secure the API endpoints.

- Containerizing
In order to modularize the Employee Service for make it suit for Microservice Architecture
enabling easier development, deployment, and scaling

- Pagination: 
Introduce pagination support for better Data handling through Apis and to improve performance. 

- Database Integration: 
integration with a Sequel/Document database according to the requirement for the data persistence.

- Exception Handling: 
further Enhance exception handling to provide meaningful error messages and responses.

- Testing: 
Improve unit tests and Integration Tests code coverage.

- Documentation: 
improve code comments and API documentation for better developer experience.

- Frontend:
Develop a frontend using React or angular and integration  for managing employees.

- caching:
Introduce in-memory data store cache service like Redis for the  improvement of performance scalability

- Configuration:
Introduce Configuration server in order to manage distributed Configuration


My experience in Java
I have over all 5+ years experience in Java.