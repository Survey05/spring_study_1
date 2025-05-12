plugins {
    `java-library`
    `maven-publish`
    id("com.diffplug.spotless") version "6.25.0"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

spotless {
    format("yaml") {
        target("**/*.yml", "**/*.yml")
        prettier().configFile(".prettierrc")
    }
    java{
        removeUnusedImports()
        googleJavaFormat()
        importOrder(
            "java",
            "jakarta",
            "lombok",
            "org.springframework",
            "",
            "\\#",
            "com.example",
            "\\#com.example"
        )
        indentWithTabs()
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
}

dependencies {
    // Lombok 라이브러리
    implementation("org.projectlombok:lombok:1.18.26")

    // Lombok의 annotation processor
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    // Spring Boot Web
    api("org.springframework.boot:spring-boot-starter-web:3.4.4") // Spring Boot 버전 추가

    // Spring Boot Configuration Processor
    api("org.springframework.boot:spring-boot-configuration-processor:3.4.4") // Spring Boot 버전 추가

    // Springdoc OpenAPI
    api("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0") // springdoc 버전 추가

    // Spring Boot JPA
    api("org.springframework.boot:spring-boot-starter-data-jpa:3.4.4") // Spring Boot 버전 추가

    // MariaDB JDBC
    api("org.mariadb.jdbc:mariadb-java-client:3.5.3") // MariaDB JDBC 버전 추가

    // Spring Boot Validation
    api("org.springframework.boot:spring-boot-starter-validation:3.4.4") // Spring Boot 버전 추가

    // Gson
    api("com.google.code.gson:gson:2.8.9")

    // Mockito
    api("org.mockito:mockito-core:4.4.0")

    // Jasypt Spring Boot Starter
    api("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")

    // Spring Boot DevTools
    api("org.springframework.boot:spring-boot-devtools:3.4.4") // Spring Boot 버전 추가

    // Spring Boot Test
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4") // Spring Boot 버전 추가
}

group = "com.example"
version = "1.0.0"
description = "spring_test"

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.test {
    useJUnitPlatform()
    systemProperties["spring.profiles.active"] = "test"
}