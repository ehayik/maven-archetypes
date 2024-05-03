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

To create a new archetype, file a pull request creating a new `module`, following the examples currently here. Important pieces:

- `pom.xml` must have `<packaging>maven-archetype</packaging>` 
- should also have a `<description>`
- `src/main/resources/META-INF/maven/archetype-metadata.xml`: defines files and directories to be copied & processed
- `src/main/resources/archetype-resources/`: the template for the new component (remember a sample .gitignore)
- `src/test/resources/projects/testInstall/{goal.txt,archetype.properties}`: defines an integration test, proving that
   the archetype can not just be instantiated, but builds successfully thereafter

## Credits

I learned a lot from the projects and resources listed below:

- [Baeldung's Guide to Maven Archetype](https://www.baeldung.com/maven-archetype)
- [Jenkins CI archetypes repository](https://github.com/jenkinsci/archetypes)
  