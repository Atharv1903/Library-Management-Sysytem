# Library-Management-Sysytem
Create a simple library management system that allows users to perform basic operations such as adding books, borrowing books, returning books, and viewing available books.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)

## Features

- Add new books to the library.
- Borrow books and check availability.
- Return borrowed books.
- Show available books in the library.
- Unit tests to ensure code correctness.

## Technologies

- Java
- JUnit 5 for unit testing
- Gradle for project management and build automation

## Getting Started

To get a local copy of this project up and running on your machine, follow the steps below.

### Prerequisites

Before you begin, ensure you have the following installed:

- Java (version 8 or higher)
- Gradle (for building and running tests)

You can check your installations by running:
```bash
java -version
gradle -version

### Project Structure

library-management-system/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── main/java/Book.java            # Class representing a Book
│   │       └── main/java/Library.java         # Class representing the Library system
│   ├── test/
│   │   └── java/
│   │       └── test/java/LibraryTest.java     # Unit test cases for the Library class
├── build.gradle                               # Gradle build script
├── settings.gradle                            # Gradle settings file
└── README.md                                  # Project README with instructions and information
