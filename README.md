# TP Spring DATA REST && GRAPH QL 

## Description
TPSpringDATA is a Spring Boot application that demonstrates the use of Spring Data JPA, Spring Data REST, and GraphQL. The application manages entities such as `Centre`, `Etudiant`, `Auteur`, and `Livre`.

## Requirements
- Java 21
- Maven
- IDE (IntelliJ IDEA recommended)

## Dependencies
- Spring Boot Starter Data JPA
- Spring Boot Starter Data REST
- Spring Boot Starter GraphQL
- H2 Database
- Lombok
- Spring Boot Starter Test
- Spring GraphQL Test
- Spring WebFlux (test scope)
- Spring Boot Starter WebSocket

## Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/Soufiane4906/TPSpringDATA.git
   ```
2. Navigate to the project directory:
   ```sh
   cd TPSpringDATA
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage
### GraphQL Endpoints
- Access the GraphQL playground at `http://localhost:8080/graphql`.

#### Sample Queries
- Get all `Auteurs`:
  ```graphql
  query {
    auteurs {
      nom
    }
  }
  ```
- Get a specific `Auteur` by ID:
  ```graphql
  query {
    auteur(id: 1) {
      nom
    }
  }
  ```
- Get all `Centres`:
  ```graphql
  query {
    getAllCentres {
      nom
    }
  }
  ```

### REST Endpoints
- The application exposes REST endpoints for `Centre`, `Etudiant`, `Auteur`, and `Livre` entities through Spring Data REST.

## Database
- The application uses an in-memory H2 database. The database schema is automatically created based on the JPA entities.

## Entities
### Centre
- Fields: `id`, `nom`, `adresse`, `etudiants`
- `nom` is a required field.

### Etudiant
- Fields: `id`, `nom`, `prenom`, `gender`, `email`, `centre`

### Auteur
- Fields: `id`, `nom`, `livres`

### Livre
- Fields: `id`, `titre`, `prix`, `auteur`

## Running Tests
- To run the tests, use the following command:
  ```sh
  mvn test
  ```

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
