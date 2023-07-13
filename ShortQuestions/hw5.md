# Database
See database folder under Coding.

# Rest API
* GET: Use the GET method to retrieve data from a server. It should only be used for read operations that do not have any side effects. GET requests should not modify any data on the server.
Example: Retrieving a user's profile information or fetching a list of products.

* PUT: The PUT method is used to update or replace an entire resource on the server. When making a PUT request, you typically send the complete representation of the resource you want to update.
Example: Updating a user's profile with new information.

* POST: The POST method is used to submit data to the server to create a new resource. It is often used for creating new records on the server or submitting form data. POST requests may have side effects, such as modifying data or initiating a process on the server.
Example: Creating a new user account or submitting a contact form.

* DELETE: As the name suggests, the DELETE method is used to delete a resource on the server. It is used to remove the specified resource from the system.
Example: Deleting a user account or removing a specific item from a shopping cart.

* PATCH: The PATCH method is used to make partial updates to a resource. It is typically used when you want to modify specific fields or properties of a resource without replacing the entire representation.
Example: Updating only the address field of a user's profile.

* Payload: The payload, also known as the request body, is the data sent in the body of an HTTP request, typically for operations like creating or updating a resource. The payload can be in various formats such as JSON, XML, or form data. It carries the main content of the request and is used to transmit complex or structured data.

* Request Parameters: Request parameters, also known as query parameters or query strings, are used to pass data in the URL of an HTTP request. They are appended to the URL after a "?" symbol and are in the form of key-value pairs. Request parameters are commonly used for filtering, sorting, or providing additional information to an API endpoint.

* Path Variables: Path variables, also known as URL parameters or route parameters, are used to pass dynamic values within the URL path itself. They are denoted by a placeholder in the URL and are typically used to identify a specific resource or entity.


# API Design

## API collection Examples
[Twitter](https://developer.twitter.com/en/docs/twitter-api)
[paypal](https://developer.paypal.com/api/rest/postman/)

## Design a collection of APIs for a Blog
* get all posts
    * Method: GET
    * Endpoint: `/myblog/api/posts`
    * Description: get all posts

* get one post
    * Method: GET
    * Endpoint: `/myblog/api/posts/{postId}`
    * Description: get one post with path varibale postId

* new post
    * Method: POST
    * Endpoint: `/myblog/api/posts`
    * Description: create new posts, content need to be in the request body

* update post
    * Method: PUT
    * Endpoint: `/myblog/api/posts/{postId}`
    * Description: update exisiting post, path variable is id, updated content in request body

* delete one post
    * Method: DELETE
    * Endpoint: `/myblog/api/posts/{postId}`
    * Description: delete post with given Id

## Design API
# 1
`GET`: `/api/{customerId}/payments`
# 2
`GET`: `/api/{customerId}/orders?fromDate=2022-10-10&toDate=2022-10-24`
# 3
`GET`: `/api/{customerId}/address`
# 4
`GET`: `/api/{customerId}/payments`
`GET`: `/api/{customerId}/address`
