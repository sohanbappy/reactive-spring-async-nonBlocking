# reactive-spring-async-nonBlocking   (Web-Flux, Mongo)
Try to develop Spring Reactive Application [Project Reactor](https://projectreactor.io/)

## Mono, Flux

###### Advantages
* async
* non-blocking
* back-pressure (DB)

###### PreRequisite 
* Lambda
* Stream API (forEach,filter -Consumer,Subscriber,Predicate)
* map,flatMap
* **MongoDB**


***N.B: Using MongoRepository (no enough support for mysq - RBDMS)***

**Ref:** 

https://spring.io/projects/spring-data-r2dbc

https://github.com/jasync-sql/jasync-sql

https://github.com/mirromutth/r2dbc-mysql

### Dummy Input (MongoUser)
```
[
  {
    "id": "6179b0175c7dcd208c5a8312",
    "userId": 2,
    "name": "sohanUpdated",
    "phone": "1234",
    "email": "sohan@"
  }
]
```
