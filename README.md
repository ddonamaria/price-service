
# 🏷️ Price Service

## 📌 About the project
**Price Service** is a **REST** service that allows querying product prices at different points in time.  
It has been developed using **Java** and **Spring Boot**, following a **hexagonal architecture** and following the **API First** principle for API definition.


## 🛠️ Technologies used

This project has been built with the following technologies:

- **Java 21**
- **Spring Boot 3.4.3**
- **In-memory H2 Database**
- **OpenAPI** → API Definition
- **OpenAPI Generator** → Automatic generation of DTOs and controllers
- **MapStruct** → Entity mapping
- **JUnit 5, Mockito** → Unitary tests
- **Cucumber, Gherkin** → Tests E2E
- **Docker** → Application containerization


## 🚀 Local deployment

1. Clone the repository
```sh
git clone https://github.com/ddonamaria/price-service.git
```

2. Compile the project using Maven
```sh
.\mvnw clean package
```

3. Run the application
```sh
.\mvnw spring-boot:run
```

4. Access the API locally:
   [Swagger UI](http://localhost:8080/swagger-ui/index.html)


## 🐳 Deployment with Docker

1. Build the Docker image 
```sh
docker build -t price-service:latest .
```

2. Run the Docker image in a container
```sh
docker run -p 8080:8080 price-service:latest
```


## 🧪 Run the tests

Execute unitary and integration tests:
```sh
.\mvnw test
```

Execute test E2E with cucumber:
```sh
.\mvnw verify
```
_A report is generated in HTML and JSON formats in the **target/cucumber** directory with the results of the E2E tests._


## 🗄️ Access to the H2 Database
You can access the in-memory **H2** database via browser:

- **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **Credentials**: These can be found in the [application.yml](src/main/resources/application.yaml) configuration file.


## 🔍 Development Decisions

- **Scalable Design**: The application has been designed to be easily scalable in terms of features, including abstraction layers that, although they may seem unnecessary in a small project, facilitate future extensions.
- **Layered Architecture**: A clear separation of layers has been maintained, allowing for better code organization and readability.
- **API-first**: The **API-first** principle has been followed by defining the OpenAPI specifications first and generating the model and API code automatically using OpenAPI Generator.
- **Exception Handling**: Exceptions have been handled to manage errors such as invalid parameters or missing results in queries.
- **Field Name Changes**: Some field names have been modified compared to the initially proposed requirement. 
    - **"PRICE_LIST"** has been renamed to **"PriceId"** as it acts as the unique identifier for each price.
    - **"CURR"** has been renamed to **"CURRENCY"** to follow a consistent pattern and avoid abbreviations.

