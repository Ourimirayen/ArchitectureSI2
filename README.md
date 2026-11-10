# Gestion Foyer

A Spring Boot application for managing university residences (foyers), including students, rooms, reservations, and related entities. The project is organized as a Maven application and uses Spring Data JPA with MySQL.

## Technology stack

- Java 17
- Spring Boot 3.1
- Spring Web and Spring Data JPA
- MySQL
- Lombok
- Maven

## Project structure

- `src/main/java/com/esprit/gestionfoyer` — application source (entities, repositories, services, AOP, and configuration)
- `src/main/resources/application.properties` — local datasource and JPA settings
- `pom.xml` — Maven build and dependency configuration

## Prerequisites

- JDK 17 or later
- Maven 3.2 or later
- MySQL server

## Configure the database

The default configuration connects to `localhost:3306/gestionfoyer` as `root` with an empty password. Update `src/main/resources/application.properties` to match your local MySQL setup before running the application. Do not commit real passwords or other secrets.

> **Warning:** The current configuration sets `spring.jpa.hibernate.ddl-auto=create-drop`. On startup, Hibernate recreates the schema and drops it when the application shuts down. This can delete existing data. Use only with disposable local data; change this setting before connecting to any database whose data must be retained.

## Build and run

```bash
mvn clean verify
mvn spring-boot:run
```

Alternatively, package the application and run the generated JAR:

```bash
mvn clean package
java -jar target/gestionfoyer-0.0.1-SNAPSHOT.jar
```

The application listens on port `8080` by default.

## Development notes

A `CommandLineRunner` currently seeds sample residence and student data. Review the application configuration and seed logic before using a non-disposable database. Run `mvn test` to execute the test suite.

## Contributing

Keep changes focused, preserve existing project conventions, and include tests for behavior changes. Before submitting a pull request, run `mvn clean verify` and document any configuration or database changes.
