# Track Team 730 African Marketplace API documentation

## Item related endpoints

### `POST /item` - Add a new item

Adds a new item. Request body:

```json
{
  "description": "optional_string",
  "name": "required string",
  "price": 0.0,
  "user": {
    "userId": userId
  }
  "market": {
    "marketId": marketId
  },
  "product": {
    "productId": productId
  },
}
```
