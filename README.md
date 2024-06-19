# Реализация системы мониторинга с использованием Spring Kafka

_______
![Static Badge](https://img.shields.io/badge/Java-red)
![Static Badge](https://img.shields.io/badge/Maven-blue)
![Static Badge](https://img.shields.io/badge/Spring-green)
![Static Badge](https://img.shields.io/badge/PostreSQL-%20blue)
![Static Badge](https://img.shields.io/badge/Hibernate-tan)
![Static Badge](https://img.shields.io/badge/Liquibase-blue)
![Static Badge](https://img.shields.io/badge/Kafka-brown)




### Используемые технологии:
+ *Java 17*
+ *Maven*
+ *Spring*
+ *PostreSQL*
+ *Hibernate*
+ *Liquibase*
+ *Kafka*

_________

### Перед запуском приложения измените следующие настройки БД на свои в файле application.properties сервиса Consumer_Metrics:

```java
spring.datasource.url
spring.datasource.username
spring.datasource.password
```

____
### Старт приложения

+ запустить кафку через файл ***docker-compose.yaml***
+ запустить оба сервиса

_____
### Документация
+ ***API documentation*** для Consumer_Metrics можно посмотреть после запуска приложения по ссылке: http://localhost:8082/swagger-ui/index.html#/
+ ***API documentation*** для Producer_Metrics можно посмотреть после запуска приложения по ссылке: http://localhost:8081/swagger-ui/index.html#/
