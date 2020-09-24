# Track Team 730 African Marketplace API documentation

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

### `DELETE /item/{itemId}` - Delete a specific item

Deletes item with id `{itemId}`

**Returns**

HTTP Status: `200 OK`

Data: `{}`

### `GET /item/{itemId}` - Return a specific item

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
    "userId": 0,
  }
}
```

### `PATCH /item/{itemId}` - Return a specific item

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
