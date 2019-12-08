package com.vtn;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.vtn.fcm.FCMInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;


@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
public class VtnShopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(VtnShopApiApplication.class, args);
    }

}
