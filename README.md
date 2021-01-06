# JDP-2012-01
> Project created during <a href="http://kodilla.com">Kodilla's</a> course.
> It's backend mechanics of online shop. 

## Demo
Project consists of these classes and related endpoints:

1. Product
  * /v1/product/getProducts - list of all products
  * /v1/product/getProduct - single product download
  * /v1/product/deleteProduct - product removal
  * /v1/product/updateProduct - product data update
  * /v1/product/createProduct - product creation

## Requirements
You need:
* JVM (Java Virtual Machine)
* MySQL database
* free port 8080

## Uruchomienie projektu
Projects builds using Gradle (gradlew build). You need working MySQL server: create user and database.
Write MySQL credentials into application.properties.

## Endpoints' description

1. Product
  * /v1/product/getProducts - GET method, no parameters
  * /v1/product/getProduct - GET method, give me productId
  * /v1/product/deleteProduct - DELETE method, give me productId
  * /v1/product/updateProduct - PUT method (JSON), give me full object as described below
  * /v1/product/createProduct - POST method (JSON), give me full object as described below
Example of full object in JSON:
    {
        "id": 1,
        "name": "coat",
        "description": "winter coat in brown colour",
        "price": 100,
        "groupId": "1"
    }

## Wykorzystanie
It's a result of our teamwork during Kodilla's course. You can use it on Creative Commons license. 

## Troubleshooting
We do not know any.