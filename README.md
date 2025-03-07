The App name is Hotel Ease , we created this application for hotel staff to manage the employees and perform basic crud operations between them.
The app's database is postgreSQL and the DB is uploaded to AZURE cloud (free tier) , the tables are balanced to 4NF and we have also included a SQL script file to run and create the tables
The project is well documented and we have followed the MVC design pattern , we can also implement the DTO framework if we decide to scale up the system , but as of now its not required.

The folders are -> Repository Layer , Service Layer , Controller Layer , it also has the Resources folder containing all the pertinent frontend files required for the execution.

**Table of Contents**

Prerequisites 
Installation
Configuration
Testing
Running the Application
API Endpoints
Deployment


/////////// pre - requisties ///////////////

Prerequisites

Before running the application, make sure you have the following software installed:
JDK 17 or later (for building and running the Spring Boot application)
Maven (for building the project)
PostgreSQL (for database setup)
IDE (like IntelliJ IDEA or Eclipse)
Git (for version control)

Optional:
Docker (to containerize the application and database)
AWS (for deploying to the cloud)


//////////////////// Installation /////////////////////////

Clone the Repository:
**git clone https**://github.com/Sahil9477/HotelEase.git
**Navigate to the Project Directory**: cd HotelEase
**Set up PostgreSQL Database:**
Make sure you have PostgreSQL running locally or use a cloud-based solution like AWS RDS.
Create a database hotelease and a user with the necessary permissions.
**Install Project Dependencies:**
mvn clean install

/////////////Configuration ////////////////////

spring.application.name=HotelEase

# Server Configuration
server.port=8081

# Database Configuration (replace with your own database details)
spring.datasource.url=jdbc:postgresql://localhost:5432/hotelease
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate & JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# Show SQL queries in console (for debugging)
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Optimize Hibernate Behavior
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false


////////////////    TESTING ////////////////////////

We have included one testing folder for the project as well , here are the steps to initiate with the same ..

1) **mvn test**
(This command will:
Compile the application.
Run all the tests in the src/test/java directory.)

2) **mvn -Dtest=EmployeeRepositoryTest test**
(If you want to run a specific test class or method instead of all tests, you can use the following commands:)

3) **mvn -Dtest=EmployeeRepositoryTest#testSaveEmployee test** (This will run only the testSaveEmployee method from the EmployeeRepositoryTest class.)
4) If all tests pass, you'll see something like:
 -------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.example.HotelEase.repository.EmployeeRepositoryTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.123 sec - in com.example.HotelEase.repository.EmployeeRepositoryTest

Running the Application Locally

Run the application using Maven:
mvn spring-boot:run
Access the application:
Open your browser and go to http://localhost:8081/

////////////////////////   API ENDPOINTS /////////////////////////

The following are the API endpoints available in HotelEase:
Employee Endpoints:
Create Employee: POST /api/employees
Request Body:
{
  "employeeName": "John Doe",
  "employeePosition": "Manager",
  "employeeDepartment": "Operations"
}
Get Employee by ID: GET /api/employees/{id}
Example Request: GET /api/employees/1
Update Employee: PUT /api/employees/{id}
Request Body:
{
  "employeeName": "John Doe",
  "employeePosition": "Senior Manager",
  "employeeDepartment": "HR"
}
Delete Employee: DELETE /api/employees/{id}
Example Request: DELETE /api/employees/1
Room Endpoints:
Create Room: POST /api/rooms
Get Room by Number: GET /api/rooms/{roomNumber}
Update Room: PUT /api/rooms/{roomNumber}
Delete Room: DELETE /api/rooms/{roomNumber}

///////////////   DEPLOYMENT ////////////////////////////

**Deployment**

Deploy to AWS Elastic Beanstalk
Install AWS Elastic Beanstalk CLI:
**brew install awsebcli**
Initialize Elastic Beanstalk Environment:
**eb init**
Choose the correct region.
Select the platform (e.g., Corretto 11 or Corretto 17).
Link to the appropriate AWS application.
Create and Deploy Environment:
**eb create HotelEase-env**
**eb deploy**
**Access the Deployed Application:**
After deployment, use the URL provided by AWS Elastic Beanstalk to access your app.

**/////////////   Conclusion ///////////////////**

This HotelEase Spring Boot application allows you to manage hotel employees and rooms, as well as manage reservations. It is connected to a PostgreSQL database, and you can test it using unit tests for repositories, services, and controllers. You can also deploy the application to AWS Elastic Beanstalk.
Feel free to modify or extend this application to meet your needs!
   

