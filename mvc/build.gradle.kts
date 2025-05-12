group = "com.example"
version = "1.0.0"
description = "spring_test"
java.sourceCompatibility = JavaVersion.VERSION_17

spotless {
    format("yaml") {
        target("**/*.yml", "**/*.yaml")
        prettier().configFile("${rootDir}/.prettierrc")
    }
    java {
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

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    implementation("org.springframework.boot:spring-boot-starter-web:3.4.4")
    implementation("org.springframework.boot:spring-boot-configuration-processor:3.4.4")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.4")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.5.3")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.4.4")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("org.mockito:mockito-core:4.4.0")
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")
    implementation("org.springframework.boot:spring-boot-devtools:3.4.4")

    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    systemProperties["spring.profiles.active"] = "test"
}
