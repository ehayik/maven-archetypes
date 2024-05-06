# Maven Archetypes

## Description

[Maven archetypes](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html) are project templates
from which other projects are created.

This repository contains a collection of Maven Archetypes to assist _my future self_ and other java developers in
quickly bootstrapping new projects. They're designed for bootstrapping new projects in alignment with the best industry
practices that I've learned over my career. Their aim is to simplify setting up a new project by providing templates
with an established directory layout and sensible defaults, thus reducing the time and effort required to get the project
up and running. You may find all archetypes listed below:

- [Spring Boot Template](#spring-boot-template)

## Usage

Prerequisites:

* Java 17 or higher
* Maven (either as a CLI tool or using the Maven Wrapper) > 3.6.0

To see all currently released archetypes and pick one to instantiate:

```shell
mvn archetype:generate -Dfilter=io.github.ehayik.archetypes:
```

It is also possible to run this non-interactively:

```shell
mvn archetype:generate -B \
    -DarchetypeGroupId=io.github.ehayik.archetypes \
    -DarchetypeVersion=1.0.0 \
    -DarchetypeArtifactId=spring-boot-template \
    -DgroupId=your.app.group \
    -DartifactId=cool-app \
    -Dauthor="Copyright Holder" \
    -DinteractiveMode=false 
```

## Archetypes

### Spring Boot Template

**Archetype name:** `spring-boot-template`

A comprehensive skeleton for a Spring Boot application, featuring robust defaults for seamless development.

It includes built-in support for Lombok to minimize boilerplate code, standardized code formatting for consistent code
quality, sophisticated testing mechanisms for robust software quality, and advanced programming error detection to
prevent common pitfalls. Refer to the [documentation](./spring-boot-template/src/main/resources/archetype-resources/HELP.md) on how to get started with the generated project.

This archetype is designed to boost your productivity and enhance code quality in Spring Boot-based projects. It contains
the following files/dependencies:

- Java 21, use `-DjavaVersion` to switch to Java 17 or a higher version than 21
- Spring Boot 3.2.5, use `-DspringBootVersion` to switch to a higher version
- Spring Boot Devtools dependency to provide additional development-time features
- Spring Boot Starter Test dependency for a solid testing infrastructure
- Lombok dependency to write less boilerplate code
- ErrorProne and NullAway dependencies to catch common programming mistakes
- Maven Wrapper for consistent build behavior
- A `lombok.config` file with useful defaults
- A basic `README.md` file
- A basic `.gitignore`
- A MIT `LICENSE.md` file, use `-Dauthor` to set the author's name
- Spring Boot application `Application.java`
- A basic Unit test `ApplicationTest.java`
- A basic Integration test `ApplicationIT.java`
- A basic System test `ApplicationSystemTest.java`

## Development

### Contributing a New Archetype

1. File a pull request creating a new module.
2. Update, modify, or create following files in your module:
     
- `pom.xml`: This file must include `<packaging>maven-archetype</packaging>` and a `<description>` of what your archetype does.
- `src/main/resources/META-INF/maven/archetype-metadata.xml`: This file should define the files and directories that
   will be copied and processed.
- `src/main/resources/archetype-resources/`: This directory should contain the template for your new component. Don't
   forget to include a sample .gitignore file!
- `src/test/resources/projects/testInstall/{goal.txt,archetype.properties}`: Here, define an integration test that not
only proves that your archetype can be instantiated but also build successfully.

The structure of your module should follow the existing modules as a guide. Be sure to review those before submitting 
your pull request!

Remember to follow these guidelines, and feel free to ask if you have any questions or need further clarifications.

## Credits

I learned a lot from the projects and resources listed below:

- [Guide to Maven Archetype](https://www.baeldung.com/maven-archetype)
- [Jenkins CI archetypes repository](https://github.com/jenkinsci/archetypes)
- [Improve Build Times with Context Caching from Spring Test](https://rieckpil.de/improve-build-times-with-context-caching-from-spring-test)
- [Reporting aggregated unit and integration test coverage with jacoco](https://natritmeyer.com/howto/reporting-aggregated-unit-and-integration-test-coverage-with-jacoco/) 
- [Fixing code style errors with Spotless and Maven](https://medium.com/@hubertwo/fixing-code-style-errors-with-spotless-and-maven-2d951fe0ad0c)
  