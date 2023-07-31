# Rpsgame Back

RPS game is an API REST application example built with Spring Boot framework.

# Install in Docker

```
docker build -t wittman26/rpsgame-back:latest .
docker run -d -p 49168:9191 wittman26/rpsgame-back:latest
```

To display image list
```
docker ps
```
Get container-id and set it in the following command to show logs

```
docker logs --follow <container-id>
```


# Getting Started

## Run application

```
mvn spring-boot:run
```

In windows systems type

```
./mvnw spring-boot:run
```
## Run tests

```
mvn test
```

In windows systems type

```
./mvnw test
```

The Framework **SpringBootTest** was used make the tests in this project.

## Configuration files

Properties for configuration can be found in `/rpsgame-rest/src/main/resources` path. The following properties files can be found:

```conf
    application-cert.yml
    application-dev.yml
    application-prod.yml
    application.yml
```

The file **application.yml** is configured to use `dev` profile by default which configure the following properties:

```conf
    basepath: /rpsgame/api
    server:
    port: '9191'
```

So the default endpoint is: `localhost:9191/rpsgame/api`

## Endpoints

This project uses **swagger dependency** to document the endpoints; run the application and go to the following url:
    `http://localhost:9191/v2/api-docs`
To access swagger UI and check the payloads of each endpoint, and access the following link:    
    `http://localhost:9191/swagger-ui.html`

**Important:** `Content-Type: application/json` header must be present to use API.

The most common HTTP status codes are returned when there is an error.

# Built With

This project is built using the following technologies:
- Java Spring framework.
- Java 11
- Swagger
- Lombok





