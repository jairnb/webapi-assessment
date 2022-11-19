# webapi-assessment

### Note: After execute the project some data are generated and saved in the database
## Prerequisite
- Install Postgres

- Create Database name projects


## Endpoints

- /customers
  - type: post
  - parameter: { "name": "Some name"}
  - description: save

- /customers/{id}
    - type: get
    - path variable: { "id": 1}
    - description: get by id

- /customers
    - type: get
    - description: get all


- /products
    - type: post
    - parameter: { "name": "Some name", "price": 123}
    - description: save

- /products
    - type: get
    - description: get all


- /orders
    - type: post
    - parameter: { "products": [], "customer": {}, }
    - description: save

- /orders/{id}
    - type: get
    - path variable: { "id": 1}
    - description: get by id

- /orders
    - type: get
    - description: get all

- /orders/{id}
    - type: put
    - request body parameter: { "products": [], "customer": {}, }
    - path variable: { "id": 1}
    - description: update


- /rewards/{customerId}
    - type: get
    - path variable: { "customerId": 1}
    - description: get all customer reward

- /rewards/{customerId}/{month}
    - type: get
    - path variable: { "customerId": 1, "month": 1}
    - description: get customer reward by month