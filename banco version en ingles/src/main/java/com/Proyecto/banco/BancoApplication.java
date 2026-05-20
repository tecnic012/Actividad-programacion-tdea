package com.Proyecto.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Proyecto.banco.dominio.puertos.jpa")
@EnableMongoRepositories(basePackages = "com.Proyecto.banco.dominio.puertos.mongo")
@EnableScheduling  // ✅ Activa el scheduler
public class BancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancoApplication.class, args);
    }
}