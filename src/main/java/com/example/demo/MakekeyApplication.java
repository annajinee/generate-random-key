package com.example.demo;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;

@SpringBootApplication
public class MakekeyApplication {

	public static void main(String[] args) {

		SpringApplication.run(MakekeyApplication.class, args);

			// 64byte 의 랜럼 수치를 저장
			String Key = "";
			while(true) {
				byte[] bytes = new byte[16];
				SecureRandom random = new SecureRandom();
				random.nextBytes(bytes);

				try {
					System.out.println(bytes);
					System.out.println(new String(Base64.encodeBase64(bytes, false), "UTF-8"));
					Key = new String(Base64.encodeBase64(bytes, false), "UTF-8").replace("==", "");
				} catch (Exception e) {

				}
				if(Key.matches("^[a-zA-Z0-9]*$"))
				{
					System.out.println("Find = " + Key);
					break;
				}
			}

	}

}
