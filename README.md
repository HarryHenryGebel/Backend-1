# Track Team 730 African Marketplace API documentation

## Table of Contents

- [Track Team 730 African Marketplace API documentation](#track-team-730-african-marketplace-api-documentation)
  - [Item related endpoints](#item-related-endpoints)
    - [`POST /item` - Add a new item](#post-item---add-a-new-item)
    - [`DELETE /item/{itemId}` - Delete an item](#delete-itemitemid---delete-an-item)
    - [`GET /item/{itemId}` - Retrieve an item](#get-itemitemid---retrieve-an-item)
    - [`PATCH /item/{itemId}` - Update an item](#patch-itemitemid---update-an-item)
    - [`GET /items` - Retrieve all items](#get-items---retrieve-all-items)
    - [`GET /user/items` - Retrieve all items](#get-useritems---retrieve-all-items)
  - [Authentication related endpoints](#authentication-related-endpoints)
    - [`POST /createnewuser` - Create and authenticate a new user](#post-createnewuser---create-and-authenticate-a-new-user)
    - [`POST /login` - Authenticate user](#post-login---authenticate-user)
    - [`GET /logout` and `GET /oauth/revoke-token` - log current user out from system](#get-logout-and-get-oauthrevoke-token---log-current-user-out-from-system)
  - [Miscellaneous endpoints](#miscellaneous-endpoints)
    - [`GET /markets` - Retrieve all markets](#get-markets---retrieve-all-markets)
    - [`GET /products` - Retrieve all items](#get-products---retrieve-all-products)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>

## Item related endpoints

### `POST /item` - Add a new item

Adds a new item.

**Request body**

```json
{
  "description": "optional_string",
  "name": "required string",
  "price": 0.0,
  "user": {
    "userId": userId
  },
  "market": {
    "marketId": marketId
  },
  "product": {
    "productId": productId
  }
}
```

**Returns**

HTTP Status: `201 Created`

Data: `{}`

### `DELETE /item/{itemId}` - Delete an item

Deletes item with id `{itemId}`

**Returns**

HTTP Status: `200 OK`

Data: `{}`

### `GET /item/{itemId}` - Retrieve an item

Retrieves item with id `{itemId}`.

**Returns**

HTTP Status: `200 OK`

Data:

```json
{
  "description": "string",
  "itemId": itemId,
  "name": "string",
  "price": 0,
  "market": {
    "marketId": marketId,
    "name": "string"
  },
  "product": {
    "name": "string",
    "productId": productId,
    }
  },
  "user": {
    "name": "string",
    "primaryEmail": "example-user@example-domain.com",
    "userId": userId,
  }
}
```

### `PATCH /item/{itemId}` - Update an item

Updates item with id `{itemId}`. Unaltered fields should be omitted from the
request body.

**Request body**

```json
{
  "description": "optional_string",
  "name": "required string",
  "price": 0.0,
  "user": {
    "userId": userId
  },
  "market": {
    "marketId": marketId
  },
  "product": {
    "productId": productId
  }
}
```

**Returns**

HTTP Status: `200 OK`

Data: `{}`

### `GET /items` - Retrieve all items

Retrieves all items.

**Returns**

HTTP Status: `200 OK`

Data:

```json
[
  {
    "description": "string",
    "itemId": itemId,
    "name": "string",
    "price": 0,
    "market": {
      "marketId": marketId,
      "name": "string"
    },
    "product": {
      "name": "string",
      "productId": productId
    },
    "user": {
      "name": "string",
      "primaryEmail": "example-user@example-domain.com",
      "userId": userId
    }
  }
]
```

### `GET /user/items` - Retrieve all items

Retrieves all items belonging to the currently authenticated user.

**Returns**

HTTP Status: `200 OK`

Data:

```json
[
  {
    "description": "string",
    "itemId": itemId,
    "name": "string",
    "price": 0,
    "market": {
      "marketId": marketId,
      "name": "string"
    },
    "product": {
      "name": "string",
      "productId": productId
    },
    "user": {
      "name": "string",
      "primaryEmail": "example-user@example-domain.com",
      "userId": userId
    }
  }
]
```

## Authentication related endpoints

### `POST /createnewuser` - Create and authenticate a new user

Creates and authenticates a new user and returns an authentication token.

**Request Body**

```json
{
  "primaryEmail": primaryEmail,
  "password": "user's password",
  "name": "optional name user would like to me known as"
}
```

**Returns**

HTTP Status: `201 Created`

HTTP Header:
`token: token`

### `POST /login` - Authenticate user

Authenticates the user and returns an authentication token.

**Request URL**

```
https://african-marketplace-730/login?grant_type=password&username=${primaryEmail}&password=${password}
```

**Request Headers**

```
Authorization: Basic {btoa encoded {CLIENT_ID}:btoa encoded {CLIENT_SECRET}}
Content-Type: application/x-www-form-urlencoded
```

**Returns**

HTTP Status: `200 OK`

Data:

```json
{
  "access_token": token
}
```

### `GET /logout` and `GET /oauth/revoke-token` - log current user out from system

Logs the current user out from the system

**Returns**

HTTP Status: `200 OK`

Data: `{}`

## Miscellaneous endpoints

### `GET /markets` - Retrieve all markets

Retrieves all markets.

**Returns**

HTTP Status: `200 OK`

Data:

```json
[
  {
    "marketId": marketId,
    "name": "Market city, market country"
  }
]
```

### `GET /products` - Retrieve all products

Retrieves all products.

**Returns**

HTTP Status: `200 OK`

Data:

```json
[
  {
    "product_id": productId,
    "product_name": "Product name",
    "subcategory_id": subcategory_id,
    "subcategory_name": "Subcategory name",
    "category_id": category_id,
    "category_name": "Category name"
  }
]
```
