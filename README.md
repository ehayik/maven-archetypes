# (WIP) Maven Archetypes

## Description

Maven archetypes intended for more efficient project management. They're designed to assist _my future self_ in quickly 
bootstrapping new projects in alignment with the best industry practices that I've learned over my career. Their aim is 
to simplify setting up a new project by providing templates with an established directory layout and sensible defaults,
thus reducing the time and effort required to get the project up and running.

## Usage

To see all currently released archetypes and pick one to instantiate:

```bash
mvn archetype:generate -Dfilter=org.github.ehayik.archetypes:
```

It is also possible to run this non-interactively:

```bash
mvn archetype:generate -B \
    -DarchetypeGroupId=org.github.ehayik.archetypes \
    -DarchetypeVersion=1.0.0 \
    -DarchetypeArtifactId=spring-boot-template \
    -DgroupId=your.app.group \
    -DartifactId=cool-app \
    -Dauthor="Copyright Holder" \
    -DinteractiveMode=false 
```

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

- [Baeldung's Guide to Maven Archetype](https://www.baeldung.com/maven-archetype)
- [Jenkins CI archetypes repository](https://github.com/jenkinsci/archetypes)
  