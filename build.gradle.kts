plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.0"
    id("io.freefair.lombok") version "6.6.1"
    id("com.diffplug.spotless") version "6.25.0"
    `maven-publish` // ← 추가
}

group = "com.example"
version = "1.0.0"
description = "spring_test"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "io.spring.dependency-management")
}
