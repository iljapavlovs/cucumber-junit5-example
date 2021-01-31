
plugins {
    java
    idea
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:latest.release") {
        because("we want to use JUnit 5")
    }
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:latest.release") {
        because("Cucumber relies on jupiter-engine to resolve tests")
    }
    testImplementation("io.cucumber:cucumber-java:latest.release") {
        because("we want to use Cucumber JVM")
    }
    testImplementation("io.cucumber:cucumber-junit-platform-engine:latest.release") {
        because("we want to use Cucumber with JUnit 5")
    }
    testImplementation("io.cucumber:cucumber-picocontainer:latest.release") {
        because("we want to use dependency injection in our Cucumber tests")
    }

    testImplementation("io.qameta.allure:allure-cucumber6-jvm:2.13.8")

}

tasks {
    test {
        ignoreFailures = true
        systemProperties(System.getProperties().toMap() as Map<String, Object>)
//        systemProperty("cucumber.execution.parallel.enabled", System.getProperty("test.parallel", "false"))
        systemProperty("cucumber.plugin", "json:build/reports/cucumber.json, pretty, timeline:build/timeline")
//        systemProperty("cucumber.plugin", "json:build/reports/cucumber.json")

        systemProperty("cucumber.execution.parallel.enabled", "true")
        systemProperty("cucumber.execution.parallel.config.strategy", "fixed")
        systemProperty("cucumber.execution.parallel.config.fixed.parallelism", "3")

//        systemProperty("cucumber.plugin", "json:build/reports/cucumber.json")

        useJUnitPlatform {
            excludeTags("disabled")
        }
    }
}
