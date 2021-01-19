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

2. User
  * /v1/user/getUsers - list of all users
  * /v1/user/getUser - single user download
  * /v1/user/deleteUser - user delete
  * /v1/user/update - user data update
  * /v1/user/create - user creation

3. Order
  * /v1/order/getOrders - list of all orders
  * /v1/order/getOrder - single order download
  * /v1/order/deleteOrder - order delete 
  * /v1/order/update - order data update 
  * /v1/order/create - order creation 

4. Cart
  * /v1/cart/getCarts - list of all carts
  * /v1/cart/getCart - single cart download
  * /v1/cart/deleteCart - cart delete
  * /v1/cart/update - cart data update
  * /v1/cart/create - cart creation

5. Group
  * /v1/group/getGroups - list of all groups
  * /v1/group/getGroupById - single group download
  * /v1/group/deleteGroup - group delete
  * /v1/group/update - group data update
  * /v1/group/create - group creation


## Requirements
You need:
* JVM (Java Virtual Machine)
* MySQL database
* free port 8080

## Running the project
Projects builds using Gradle (gradlew build). You need working MySQL server: create user and database.
Write MySQL credentials into application.properties.

## Endpoints' description

1. Product
  * /v1/product/getProducts - GET method, no parameters
  * /v1/product/getProduct - GET method, give me productId
  * /v1/product/deleteProduct - DELETE method, give me productId
  * /v1/product/updateProduct - PUT method (JSON), e.g.: { "id": 1, "name": "coat", "description": "winter coat in brown colour", "price": 100, "groupId": "1" }
  * /v1/product/createProduct - POST method (JSON), e.g.: { "id": 1, "name": "coat", "description": "winter coat in brown colour", "price": 100, "groupId": "1" }

2. User
* /v1/user/getUsers - list of all users - GET method, no parameters
* /v1/user/getUser - single user download - GET method, required Long userId
* /v1/user/deleteUser - user delete - DELETE method, required Long userId
* /v1/user/update - user data update - PUT method(JSON), e.g.:  { "id": 1, "username": "Piotr", "status": "1", "userKey": 59403 },
* /v1/user/create - user creation - POST method(JSON), e.g.:  { "id": 1, "username": "Piotr", "status": "1", "userKey": 59403 },

3. Order

* /v1/order/getOrders - list of all orders - GET method, no parameters
* /v1/order/getOrder - single order download - GET method, required Long orderId
* /v1/order/deleteOrder - order delete - DELETE method, required Long orderId
* /v1/order/update - order data update - PUT method(JSON)
* /v1/order/create - order creation - POST method(JSON)

4. Cart
* /v1/cart/getCarts - list of all carts - GET method, no parameters
* /v1/cart/getCart - single cart download - GET method, required Long id
* /v1/cart/deleteCart - cart delete - DELETE method, required Long id
* /v1/cart/update - cart data update - PUT method(JSON) e.g.: { "id": 1, "name": "kurtka zimowa", "description": "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.", "price": 100, "groupId": "1" },
* /v1/cart/create - cart creation - POST method(JSON) e.g.: { "id": 1, "name": "kurtka zimowa", "description": "Pellentesque tempus interdum quam ut rhoncus. Donec ullamcorper turpis dolor. Donec euismod pretium eros et eleifend. Aliquam vulputate faucibus lorem non auctor. Vivamus erat turpis, molestie a nisl non, scelerisque luctus enim. Nunc mi mi, laoreet ac mollis nec, pharetra sit amet tortor. Vivamus a bibendum purus.", "price": 100, "groupId": "1" }

5. Group
* /v1/group/getGroups - list of all groups - GET method, no parameters
* /v1/group/getGroupById - single group download - GET method, required Long id
* /v1/group/deleteGroup - group delete - DELETE method, required Long id
* /v1/group/update - group data update - PUT method(JSON)
* /v1/group/create - group creation -POST method(JSON)

## How can I use it?
It's a result of our teamwork during Kodilla's course. You can use it on Creative Commons license. 

## Troubleshooting
We do not know any. 