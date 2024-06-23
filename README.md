# JakartaEE-Todo-Demo README

## Overview

JakartaEE-Todo-Demo is a simple demonstration project for building, cleaning, and running a Jakarta EE application using Maven and Payara Micro. This application provides a basic TODO list functionality to showcase Jakarta EE capabilities.

## Prerequisites

Before you can build and run this project, ensure you have the following installed:

- JDK 8 or later
- Maven 3.6 or later
- Payara Micro (optional, if not using the Maven plugin)

## Build

To build the project, you can use the following Maven command:

```bash
mvn package -P payara
```

## Clean

To clean the project, removing any previously built files, use the following Maven command:

```bash
mvn clean -P payara
```

## Run

To run the application using Payara Micro, use the following Maven command:

```bash
mvn package payara-micro:start
```
This command packages the application and starts it using Payara Micro, allowing you to access the application at [http://localhost:8080](http://localhost:8080).

## Additional Information

### Project Structure

The project structure follows a standard Maven layout:

```plaintext
JakartaEE-Todo-Demo/
│
├── src/
│   ├── main/
│   │   ├── java/               # Java source files
│   │   ├── resources/          # Resource files
│   │   └── webapp/             # Web application files (e.g., JSP, HTML)
│   └── test/
│       └── java/               # Test source files
│
├── pom.xml                     # Maven Project Object Model file
└── README.md                   # This README file
```
## Dependencies

Dependencies for this project are managed through the `pom.xml` file. The project utilizes Jakarta EE APIs and Payara Micro for deployment.

## Configuration

Configuration settings for the application, such as database connections or server configurations, can be adjusted in the appropriate configuration files located within the `src/main/resources` directory.



