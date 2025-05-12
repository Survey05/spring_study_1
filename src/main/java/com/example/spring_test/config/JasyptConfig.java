package com.example.spring_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

@Configuration
public class JasyptConfig {

@Bean(name = "jasyptStringEncryptor")
public StringEncryptor stringEncryptor() {
    String password = "spring_test";
    PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();

    SimpleStringPBEConfig config = new SimpleStringPBEConfig();
    config.setPassword(password);
    config.setAlgorithm("PBEWithMD5AndDES");
    config.setKeyObtentionIterations("1000");
    config.setPoolSize("1");
    config.setProviderName("SunJCE");
    config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
    config.setStringOutputType("base64");

    encryptor.setConfig(config);
    return encryptor;
}
}
