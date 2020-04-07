# ProgressBar

This is a simple console progressbar for Java. It can be used in CLI programs
to display progress for long tasks.

It was born because I could not find a simple progress bar implementation
for console based Java applications.

The inspiration came from visionmedia's [node-progress][1].

[![Build Status](https://travis-ci.org/raszi/java-progressbar.svg?branch=master)](https://travis-ci.org/raszi/java-progressbar)
[![Maven Central](https://img.shields.io/maven-central/v/hu.ssh/java-progressbar.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22hu.ssh%22%20AND%20a:%22java-progressbar%22)

```xml
<dependency>
  <groupId>hu.ssh</groupId>
  <artifactId>java-progressbar</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Usage

```java
ProgressBar progressBar = ConsoleProgressBar.on(System.out);
progressBar.tickOne();
// do something
progressBar.tick(25); // this will increase the percentage to 26
// do the rest
progerssBar.finish(); // this will finish it
```

### Example output

```
[==================================--------------------------]  57.00% 393ms
```

## Advanced configuration

```java
ProgressBar progressBar = ConsoleProgressBar.on(System.out)
    .withFormat("[:bar] :percent% :elapsed/:total ETA: :eta")
    .withTotalSteps(500);
```

## Available replacers for format

 - `:bar` the progress bar
 - `:elapsed` the elapsed time since the `start()` or the first `tick()`
 - `:percent` the percentage without the percent sign
 - `:eta` the estimated time to accomplish
 - `:total` the total time to complete

## TODOs

 - it does not check whether the progressbar has been finished or not, so don't
   call `finish()` more than once

[1]: https://github.com/visionmedia/node-progress
