# Spring Boot Template

A comprehensive skeleton for a Spring Boot application, featuring robust defaults for seamless development.
It includes built-in support for Lombok to minimize boilerplate code, standardized code formatting for consistent code
quality, sophisticated testing mechanisms for robust software quality, and advanced programming error detection to
prevent common pitfalls. This archetype is designed to boost your productivity and enhance code quality in
Spring Boot-based projects.

## Technologies Used

This project uses a number of technologies and libraries:

- **Java JDK 21**: The latest version of Java Development Kit is used for implementing the application logic.
- **Spring Boot**: An open source Java-based framework used to create a Micro Service. It is developed by Pivotal Team.
- **Maven**: A software project management and comprehension tool used primarily for Java projects.
- **Spotless**: A general-purpose formatting plugin that can be used to enforce code style and formatting rules.
- **Palantir**: A modern, lambda-friendly, 120 character Java formatter.
- **Error Prone**: A library to assists Java developers in detecting and fixing common programming mistakes during the compilation phase.
- **NullAway**: A tool to help eliminate _NullPointerException_ (NPE) in your Java code.

## Getting Started

### Prerequisites

Before you continue, please ensure you have met the following requirements:

- You have installed Java SDK version 21.
- You have a basic understanding of Java, and Spring Boot.
- You have installed an IDE that supports Java and Spring Boot applications development, such as IntelliJ IDEA

### Installing Dependencies

1. Open the project folder.
2. Run `mvn clean compile` to install the necessary dependencies from the POM file.

### Running locally

1. Run `mvn spring-boot:run`

### Code Formatting

The project follows the automatic code formatting approach to reduce 'nit' comments in code reviews, allowing engineers to
focus on the important logic rather than  [bikeshedding](https://en.wiktionary.org/wiki/bikeshedding) about whitespace
or spending time checking if there is any unused import.

The configured code standard is [Palantir Java Format](https://github.com/palantir/palantir-java-format). Its rules are
enforced on each Maven build, via _spotless-maven-plugin_.

>**NOTE**
> Palantir Java Format is  [optimized for code reviews](https://github.com/palantir/palantir-java-format#optimised-for-code-review)

#### How to ensure that every new commit is formatted properly?

This process is automated using a git pre-commit script. Installing `scripts/pre-commit` script file is as simple as putting
a file named pre-commit into the `.git/hooks` folder. This process is fully automated using _maven-resources-plugin_.

The pre-commit script won’t work if Maven is not installed. The [installation](https://maven.apache.org/install.html)
of Apache Maven is a simple process of extracting the archive and adding the `bin` directory with the `mvn` command to
the `PATH`.

#### How to disable the automatic formatter for a part of a file?

The formatter is not as clever as humans are, so it can sometimes produce less readable code, this is where disabling
the automatic formatter comes handy, to retain custom formatting in favor of readability.

```java
// spotless:off
/*
* Java comment
* that must not be reformatted.
*/
// spotless:on
```

## Credits

You may use this section to include a list of valuable resources that contributed to the project, providing the due
credit to their authors.
