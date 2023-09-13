#  Person Api Documentation

*This is the HNGx level two task documentation.This documentation provides an overview of this simple CRUD application Apis(Creat,Read,Update,Delete).The application was built to store data related to a person.*

## Table of content
1. [ Introduction ](#introduction)
2. [ Getting Started ](#GettingStarted)
    - [ Prerequisites](#Prerequisites)
    - [ Installation](#Installation)
   
3. [ Usage](#Usage)
   - [ Endpoints ](#Endpoints)
4. [ Deployment ](#Deployment)
5. [ Validation ](#Validation)
6. [ Error Handling ](#ErrorHandling)


## Introduction
*This simple crud operation application was built in java, utilizing the springboot framework and providing the following functionality:*
- Create a new person(add person)
- Read a person from database(get person)
- Update an existing person
- Delete a person from database

## Getting Started
### Prerequisites
*To run this application, you need the following:*
* Java Development Kit (JDK) 8 or later
* Apache Maven or Gradle (for building the project)
* Your preferred Integrated Development Environment (IDE)
* MySQL database (or a database of your choice)

### Installation
*Follow these steps to set up and run this application*
#### 1. Clone the repository on your local machine:
*Go into  a desired folder on your local machine and open the folder on your
command prompt for Windows users and terminal for linux users then run the command 
below replace the placeholder <git-hub-repository-url> with the actual url to this repository you would find that by clicking in the 
green code button on the right had side of the repository* 
```
git clone <git-hub-repository-url>
```
#### 2. Open the cloned project in your IDE.
#### 3. Replace the existing database configuration in the application.properties file to a configuration that suitable for you.
#### 4. Build and run the application: 
```
mvn spring-boot:run
```
or

```
mvn clean install
```
## Usage
### Endpoints
*The following endpoints are available:*
* `POST  /api`  creat a new person.
* `GET /api/user_id` get a person.
* `PATCH /api/user_id` updated  a person.
* `DELETE /api/user_id` delete a person.

### Request and Response Examples

*Create a new person*
Request:
* Url : `https://hngxtasktwo-production.up.railway.app/api`
* Method : POST
* Header :
    * `Content-Type : application/json`
* Body:
```
{
    "name" : "Madam Fola"
}
```

Response (HTTP 200 OK):

```
{
    "data": {
        "id": 202,
        "name": "Madam Fola"
    },
    "successful": true
}
```

Bad Response (HTTP 400 BAD REQUEST):
* Body:
```
{
    "data": "This person already exist",
    "successful": false
}
```
*Get a person:*

Request:
* Url : `https://hngxtasktwo-production.up.railway.app/api/user_id`
* Method : GET
* PARAMETER : `user_id`


Response (HTTP 200 OK):
```
{
    "data": {
        "id": 202,
        "name": "Mada"
    },
    "successful": true
}
```

Bad Response (HTTP 400 BAD REQUEST):
* Body:
```
{
    "data": "Invalid details entered",
    "successful": false
}
```
*Updated  a person*

Request:
* Url : `https://hngxtasktwo-production.up.railway.app/api/user_id`
* Method : PATCH
* PARAMETER : `user_id`
* Header :
    * `Content-Type : application/json`
* Body:
```
{
    "name" : "Jennifer Musah Mercy"
}
```


Response (HTTP 200 OK):
```
{
    "data": {
        "id": 202,
        "name": "Jennifer Musah Mercy"
    },
    "successful": true
}
```

Bad Response (HTTP 400 BAD REQUEST):
* Body:
```
{
    "data": "Invalid details entered",
    "successful": false
}
```
*Delete a person*

Request:
* Url : `https://hngxtasktwo-production.up.railway.app/api/user_id`
* Method : PATCH
* PARAMETER : `user_id`

Response (HTTP 200 OK):
```
{
    "data": "Deleted Successfully",
    "successful": true
}
```

Bad Response (HTTP 400 BAD REQUEST):
* Body:
```
{
    "data": "Invalid details entered",
    "successful": false
}
```

## Deployment
*After this project as been set up, following the above guidelines you can as well deploy.
Deploying this project requires you to have decided what platform  you desire to host the project, 
if you would be using platforms like render, then here are the steps to take:*
* add a docker file to the project.
* Push to a git-hub repo.
* Go to the Render platform and create an account which is free.
* Select the project you want to deploy from git and provide all required information.
* Add all needed environment variables.
* Then click the deploy button.

*For platforms like Railway these are the steps to take:*
* Push the project to a git-hub repository.
* Create a Railway account which is also free.
* Click on the add a new service button and select form git-hub
* Link git-hub account to railway account.
* Select the project you want to deploy from the railway platform.
* Add a new service, a database, any database of your choice.
* Get the database connection details.
* Add it to the deploying project environment variable.

*it would automatically re-deploy and that is all, click on the successfully 
deployed project and go to settings to generate a domain*

## Validation
*The API enforces validation for the name field to ensure it 
contains only letters (alphabetic characters).*
## Error Handling
*The API handles validation errors gracefully and returns appropriate error responses.
Error responses include a meaningful error message.*
