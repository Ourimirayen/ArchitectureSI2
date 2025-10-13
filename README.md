# Gestion Foyer - Case Study

This is a Spring Boot application for managing university dormitories (foyers), reservations, and students.

## Project Structure

*   `src/main/java/com/esprit/gestionfoyer`: Main package
    *   `entities`: JPA entities
    *   `repositories`: Spring Data JPA repositories
    *   `services`: Service layer (business logic)
    *   `aop`: AOP aspects
    *   `config`: Configuration classes, including data seeding
*   `src/main/resources`: Application configuration
    *   `application.properties`: Datasource and JPA configuration
*   `pom.xml`: Maven project configuration

## Technologies Used

*   Java 17
*   Spring Boot 3
*   Spring Data JPA
*   Hibernate
*   MySQL
*   Lombok
*   Maven

## Setup and Run

1.  **Prerequisites**:
    *   JDK 17 or later
    *   Maven 3.2+
    *   MySQL server running

2.  **Database Configuration**:
    *   Open `src/main/resources/application.properties`.
    *   Update `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` to match your MySQL setup. The application is configured to create the database `gestionfoyer` if it does not exist.

3.  **Build the project**:
    ```bash
    mvn clean install
    ```

4.  **Run the application**:
    ```bash
    java -jar target/gestionfoyer-0.0.1-SNAPSHOT.jar
    ```

The application will start on port `8080`.

## Verification

*   Upon starting, the application will drop and re-create the database schema based on the entities.
*   A `CommandLineRunner` is configured to seed the database with sample data, including universities, foyers, blocs, chambres, and students.
*   You can connect to your MySQL database using a tool like MySQL Workbench to verify that the tables have been created and populated with data.
*   The following tables should be created: `universite`, `foyer`, `bloc`, `chambre`, `etudiant`, `reservation`, and the join table `reservation_etudiant`.
*   Check the application logs for output from the scheduler and AOP aspect.