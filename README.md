# go-green


SETUP PROJECT
1. Clone this project
   - git clone git@github.com:jdcruz-dev/go-green.git
2. Switch to develop branch
   - git chckout develop
3. Import project in STS
   - Import as maven project
4. Right Click project to update maven 
   - Click Maven -> Update Project
5. Run Project Click Maven install or Generate resources
   - Right Click Project look for Run as or Debug as then choose Maven install or Generate resources
   NOTE: Make sure you already setup your database. Please see setup database to setup db
6. Run the project
   - Right Click Run as SpringBootApp
   
SETUP DATABASE
1. PostgresSql
   - You can import this in PG admin or any tool 
   - Database config is default (Please see application.properties in go-green project)
   
2. Create Database
   - Get the sql script in the project 
   - /green/src/main/resources/db/CREATE_DATABASE.sql
   - run the CREATE_DATABASE.sql file
 
3. Create Table
   - Get the sql script in the project 
   - /green/src/main/resources/db/CREATE_TABLE_FLIGHT.sql
   - run the CREATE_TABLE_FLIGHT.sql

HOW TO RUN IN POSTMAN
1. Open postman
2. Get All Flights [GET METHOD]
   - http://localhost:8181/api/flights
   - Set Headers
      - Accept : application/json
      - Content-Type : application/json
   ![image](https://user-images.githubusercontent.com/60128761/196395370-5fc17e7b-2831-4e12-b21a-4b8134c3ec4f.png)
   
3. Get All Flights by airlineCode [GET METHOD]
   - http://localhost:8181/api/flights?airlineCode=CX
   - Set Headers
      - Accept : application/json
      - Content-Type : application/json
   - Query Params
      - airlineCode
   Note: If airlineCode is not empty then filter response else return all
   ![image](https://user-images.githubusercontent.com/60128761/196395985-b9ca2e86-0a63-41b8-a9cf-acd82b13edb1.png)

4. Add Flight [POST METHOD]
  - http://localhost:8181/api/flight
  - Set Headers
      - Accept : application/json
      - Content-Type : application/json
  - Set FlightRequestDTO payload
  - Sample payload
    {
      "flightNumber": "QF588",
      "departurePort": "MEL",
      "arrivalPort": "SYD",
      "airlineCode": "CX",
      "departureTime": "2023-04-27T10:15:30",
      "arrivalTime": "2023-04-30T10:15:30"
    }
  NOTE: Please take note of the format of the departuretime and arrival time if the format is not the same as the above it will return bad request exception
  
All API returns this http code
200 - ok 
400 - Bad request
404 - Not Found


  
