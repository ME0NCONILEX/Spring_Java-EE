## Getting Started with Spring / Java EE

### IOC - DI 
( Will be continued / refactored)
![](J:\JAVA\spring\mySpringMasterRev\myImg\4layer0nTop.png)
* Spring Boot is built on top of the Spring Framework. It's a more automated and simplified version of Spring.
  Spring Boot Architecture has (only) four layers:
#### Presentation Layer - is at the top of the architecture and is responsible for:
  - Performing authentication
  - Converting JSON data into an object (and vice versa)
  - Handling HTTP requests
  - Transfer of authentication to the business layer
    
The presentation layer is the equivalent of the Controller class --> handles all the incoming REST API requests (GET, POST, PUT, DELETE, PATCH) from the Client.
  #### Business Layer - is responsible for:
  - Performing validation
  - Performing authorization
  - Handling of business logic and rules
This layer is the equivalent to the Service class. In short, the business logic in software engineering is where we decide what the software needs to do.
The Business layer communicates with both the Presentation layer and the Persistence Layer 
#### Persistence Layer- is responsible for:
  - Containing storage logic
  - Fetching objects and translating them into database rows (and vice versa)
This layer is the equivalent of the Repository interface. We write database queries inside this interface.
The Persistence layer is the only layer that communicates with the Business layer and the Database layer.
#### Database Layer - is responsible for:
  - Performing database operations (mainly CRUD operations).
This layer is the actual database that we decide to use to build our application.  
  

#### About Spring Boot workflow
![](..\mySpringMasterRev\myImg\SBworkflow.png)
#### Spring Boot workflow acting:

1. The Client makes an HTTP request.
2. The Controller class receives the HTTP request.
3. The Controller understands what type of request will process, and then it deals with it.
4. If it is needed, it calls the service class.
5. The Service Class is going to handle business logic. It does this on the data from the database.
6. OK? --> JSP page.

* * *

#### (exempel)

![](J:\JAVA\spring\mySpringMasterRev\myImg\J2EE.jpeg)

![](J:\JAVA\spring\mySpringMasterRev\myImg\dao.jpeg)

![](J:\JAVA\spring\mySpringMasterRev\myImg\model.jpeg)
































___
