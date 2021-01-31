# Cucumber with JUnit5

This repository contains an example project that integrates [Cucumber](https://cucumber.io/) with [JUnit5](https://junit.org/junit5/). It is the same setup explained in the [blog post](https://www.blog.cronn.de/en/testing/2020/08/17/cucumber-junit5.html).



## Features:
* Run in parallel - can be set in `junit-platform.properties`, `cucumber.properties` or in gradle system properties
```
systemProperty("cucumber.execution.parallel.enabled", "true")
systemProperty("cucumber.execution.parallel.config.strategy", "fixed")
systemProperty("cucumber.execution.parallel.config.fixed.parallelism", "3")
```
* Reporting - can check that tests are executed in parallel - `build/timeline`