# ATM CRUD Java Maven Project

Simple ATM management application built with Java Swing and Maven.

## Project Overview

- Java Swing GUI application for bank account operations.
- Supports CRUD-style features: login, deposit, withdraw, balance check, fast cash, pin change, and mini statement.
- Uses MySQL via `mysql-connector-java`.
- Main class: `com.Bank.Main`.

## Prerequisites

- Java JDK 11 or newer
- Maven
- MySQL server

## Setup

1. Clone or copy the project into a local folder.
2. Create a MySQL database and configure the connection in `src/main/java/com/Bank/Util/DataBase.java` if needed.
3. Ensure the database contains the required tables and sample data for the ATM application.

## Build

From the project root:

```bash
mvn clean package
```

This downloads dependencies, compiles the sources, and builds the application jar.

## Run

### Option 1: Run with Maven

```bash
mvn exec:java
```

### Option 2: Run the generated JAR

```bash
java -jar target/Bank-application-1.0.0.jar
```

## Notes

- The project uses the `mysql-connector-java` dependency defined in `Pom.xml`.
- If database connection details change, update `DataBase.java` accordingly.
- The UI classes are located in `src/main/java/com/Bank/Gui/`.

## Folder Structure

- `src/main/java/com/Bank/` - application source code
- `src/main/java/com/Bank/Dao/` - data access logic
- `src/main/java/com/Bank/Gui/` - Swing GUI screens
- `src/main/java/com/Bank/Util/` - database utilities
- `target/` - Maven build outputs
