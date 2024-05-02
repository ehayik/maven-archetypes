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
    -DarchetypeArtifactId=empty-spring-boot \
    -DgroupId=your.app.group \
    -DartifactId=cool-app \
    -Dauthor="Copyright Holder" \
    -DinteractiveMode=false 
```