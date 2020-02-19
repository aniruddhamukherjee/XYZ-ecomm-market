# XYZ-ecomm-market
ecommerce back end services

XYZ B2C ecommerce market place is working on building a solution to search an online product catalogue. 

This is a fully functional spring-boot web service with pagination (20 results at a time) and data caching (conditional and time interval, 2 hrs).
It uses H2 embedded RDMS database. 

## Information

URLS exposed  >>

GET : /products/pageNum/{pageNum} :  Api for fetching all products with details \
GET : /products/brand/{brand}/pageNum/{pageNum} :  Api for fetching products details by brand \
GET : /products/price/min/{min}/max/{max}/pageNum/{pageNum} : Api for fetching products details by price range  \
GET : /products/{sku}  : Api for fetching product details by SKU  \
GET : /products/seller/{supplier} :  Api for fetching product count by SKU and seller  \
GET : /products/type/{type}/size/{size}/pageNum/{pageNum}  : Api for fetching products details by type and size \
GET : /products/type/{type}/color/{color}/pageNum/{pageNum} : Api for fetching products details by type and color \

### Prerequisites
```
java 8+ 
maven
```

### App Setup
```
In the root dir run -> 
mvn spring-boot:run

You will be able to access the application through:
http://localhost:8081/products/<api-relative-url>
  
URL to access embedded H2 Database console :
http://localhost:8081/h2-console/

JDBC URL : jdbc:h2:mem:testdb
username: admin
password : admin
```
H2 DB schema setup file : 
```
src/main/resources/schema.sql
```
H2 DB data setup file : 
```
src/main/resources/data.sql
```

Sample Product json response : 
```
[
  {
    "id": 1,
    "name": "Adidas Shirt-1",
    "brand": "Adidas",
    "type": "Shirt",
    "supplier": "MukherjeeSuppliers",
    "availableCount": 1000,
    "price": 500.5,
    "size": 40,
    "color": "Green"
  },
  {
    "id": 2,
    "name": "Nike Cap-1",
    "brand": "Nike",
    "type": "Cap",
    "supplier": "AniruddhaRetail",
    "availableCount": 5000,
    "price": 200.25,
    "size": 36,
    "color": "Yellow"
  }
  ]
  ```
## Running the tests
In the root dir run -> 
```
mvn test
```

## Deployment
No need of separate deployment to server. Embedded Tomcat takes care of it.


## Author

* Aniruddha Mukherjee  - - [https://github.com/aniruddhamukherjee](https://github.com/aniruddhamukherjee)



