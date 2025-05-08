package com.example.spring_test.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class JasyptTest {

  @Test
  void encryptTest() {
    String id = "user";
    String password = "user";

    System.out.println("ENC("+jasyptEncoding(id)+")");
    System.out.println("ENC("+jasyptEncoding(password)+")");
  }

  public String jasyptEncoding(String value) {
    String key = "spring_test";
    StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
    pbeEnc.setAlgorithm("PBEWithMD5AndDES");
    pbeEnc.setPassword(key);
    return pbeEnc.encrypt(value);
  }

}
