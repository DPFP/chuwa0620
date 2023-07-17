# HW30 API
**API Design**
**Find 2 collection of APIs example.**
PayPal:
- Create draft invoice
POST /v2/invoicing/invoices
- List invoices
GET /v2/invoicing/invoices
- Send invoice
POST /v2/invoicing/invoices/{invoice_id}/send
- Create order
POST
/v2/checkout/orders
- Show order details
GET /v2/checkout/orders/{id}
- Update order
PATCH /v2/checkout/orders/{id}

Youtube:
- Get comments
GET https://www.googleapis.com/youtube/v3/comments
- Insert comments
POST https://www.googleapis.com/youtube/v3/comments
- Mark comment as spam
POST https://www.googleapis.com/youtube/v3/comments/markAsSpam
- Get captions
GET https://www.googleapis.com/youtube/v3/captions
- Insert captions
POST https://www.googleapis.com/upload/youtube/v3/captions
- Delete captions
DELETE https://www.googleapis.com/youtube/v3/captions

**Design a collection of APIs for a Blog Website, please specify GET POST PUT DELETE**
- Retrieve all blog posts:
GET /api/posts
- Retrieve a specific blog post:
GET /api/posts/{postId}
- Create a new blog post:
POST /api/posts
Request body: { "title": "Example Title", "content": "Example Content" }
- Update an existing blog post:
PUT /api/posts/{postId}
Request body: { "title": "Updated Title", "content": "Updated Content" }
- Delete a blog post:
DELETE /api/posts/{postId}
- Retrieve all comments for a specific blog post:
GET /api/posts/{postId}/comments
- Retrieve a specific comment for a blog post:
GET /api/posts/{postId}/comments/{commentId}
- Create a new comment for a blog post:
POST /api/posts/{postId}/comments
Request body: { "content": "Example Comment" }
- Update an existing comment for a blog post:
PUT /api/posts/{postId}/comments/{commentId}
Request body: { "content": "Updated Comment" }
- Delete a comment for a blog post:
DELETE /api/posts/{postId}/comments/{commentId}

**Design APIs for the following features**
1.  find the customer's payments, like credit card 1, credit card 2, paypal, Apple Pay.
GET /api/customers/{id}/payments
2.  Find the customer's history orders from 10/10/2022 to 10/24/2022
GET /api/customers/{id}/orders?start_date=2022-10-10&end_date=2022-10-24
3.  find the customer's delievery addresses
GET /api/customers/{id}/delivery-addresses
4.  If I also want to get customer's default payment and default delievery address, what kind of the API (URL) 
should be?
GET /api/customers/{id}/payments/defaults
GET /api/customers/{id}/delivery-addresses/defaults