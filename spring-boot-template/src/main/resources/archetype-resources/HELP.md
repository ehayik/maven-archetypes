# Getting Started

This archetype generates a maven project with the following structure:

```
mvnw
mvnw.cmd
pom.xml
.gitignore
lombok.config
HELP.md
README.md
LICENSE.md
.mvn
├── wrapper
│   └── maven-wrapper.properties
└── jvm.config
scripts
└── pre-commit
src
├── main
│   ├── java
│   │   └── org
│   │       └── acme
│   │           └── Application.java
│   └── resources
│       └── application.yml
│       
└── test
│   ├── java
│   │   └── org
│   │       └── acme
│   │           └── ApplicationIT.java
|   |           └── ApplicationSystemTest.java
|   |           └── ApplicationTest.java
|   |           └── SystemTest.java
|   |
│   └── resources
│       └── application-system-tests.yml
```

### Prerequisites

Before you continue, please ensure you have met the following requirements:

- You have installed Java SDK version 21.
- You have a basic understanding of Java, and Spring Boot.
- You have installed an IDE that supports Java and Spring Boot applications development, such as IntelliJ IDEA

### Running Commands

All the commands listed in this guide should be executed in your system's command line interface—such as Terminal for
macOS and Linux or Command Prompt for Windows—while positioned within the root directory of your project.

You can navigate to your project root by using the following command:
`cd /your/project/path`
where `/your/project/path` should be replaced by the path where your project is located on your machine.

Once you're within the project's root directory, you can execute the commands.

To remind which directory you're in at any time, you can use the command `pwd` (print working directory) in macOS/Linux
or `cd` with no arguments in Windows. This will output the current directory you're in.

Now, let's look at how to install dependencies, run the application, and conduct testing.

### Installing Dependencies

1. Open the project folder.
2. Run `mvn clean compile` to install the necessary dependencies from the POM file.

### Running locally

1. Run `mvn spring-boot:run`

### Testing

The generated project adheres to the [Test Pyramid](https://martinfowler.com/bliki/TestPyramid.html) strategy for ensuring
code quality, encompassing three levels from lower to higher as follows:

1. Unit tests for testing individual components in isolation.
2. Integration tests for testing the interaction between components.
3. System tests for testing the application as a whole, in an environment that mimics production.

Its essential point is that you should have many more low-level tests than high level tests running.

> The test pyramid is a way of thinking about how different kinds of automated tests should be used to create a balanced
> portfolio.
> ~ Martin Fowler

Here's how you can run them:

- **All Tests (Unit, Integration & System tests):** Use the command `mvn verify`.
- **Unit Tests only:** Use the command `mvn verify -DskipITs`.
- **To skip Integration tests:** Use the command `mvn verify -Dintegration-test.skip=true`.
- **To skip System tests:** Use the command `mvn verify -Dsystem-test.skip=true`.

These commands can either be run in the terminal or in the IntelliJ "Run Anything" dialog (accessed by pressing `Ctrl` twice).

>**NOTE**:
> Typically, integration & system tests take more time to run so you might want to exclude them during development and
> run only before checking in the code.

We strongly recommend running these tests as you develop and not just before the commit, as this might help catch issues
early on.

When it comes to testing using Maven for Java applications, both the `test` and `verify` build phases are of importance. 
As part of the`test` phase, we're running our unit tests with the [Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin/),
and with `verify` our integration & system tests are executed by the [Maven Failsafe Plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/index.html).

The suggestion to use unit, integration, and system tests are guidelines designed based on best practices in industry.
They provide a convenient and robust way to ensure the reliability and correctness of your codebase

However, the developer or team is always free to define the testing levels that they find most relevant and beneficial
to the project or the organization's policies. The methods to run and skip specific tests, given in the document, would
remain valid, exhibiting how to achieve this using Maven.

For a more comprehensive understanding of establishing the testing environment, I recommend reading
[Maven Setup For Testing Java Applications](https://rieckpil.de/maven-setup-for-testing-java-applications/). It provides
valuable insights into setting up and managing the testing framework using Maven for Java applications.

Additionally, for a deep dive into testing with Spring Boot Starter Test, consider reading the
[Guide to Testing With the Spring Boot Starter Test](https://rieckpil.de/guide-to-testing-with-spring-boot-starter-test). 
The guide offers comprehensive information and practical examples about testing in a Spring Boot application.

##### Aggregated Unit, Integration & System Tests Coverage Report

In the context of this project, the [JaCoCo plugin](https://www.jacoco.org/jacoco/trunk/doc/maven.html) is configured to
automatically generate unit, integration & system test coverage reports whenever the tests are run. This means you don't
need to execute any additional commands to create these reports. The reports are saved with the following names:

- **Unit tests:** `jacoco-unit-tests`
- **Integration & System tests:** `jacoco-integration-tests`
- **Merged Report:** `merged`

Furthermore, These reports can be found in your project's target directory (for example, `target/site/jacoco`) after
running the tests. You can open them with any web browser to view the test coverage in detail.

Additionally, for those who are interested in a more in-depth understanding of how to report aggregated unit and integration
test coverage with JaCoCo, you might find this [article](https://natritmeyer.com/howto/reporting-aggregated-unit-and-integration-test-coverage-with-jacoco/)
useful. It's not a requirement but a recommended read for a deeper comprehension.

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

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#using.devtools)