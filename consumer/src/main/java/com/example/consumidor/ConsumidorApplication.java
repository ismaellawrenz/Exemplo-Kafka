package com.example.consumidor;


import org.apache.kafka.clients.admin.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@SpringBootApplication

public class ConsumidorApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsumidorApplication.class, args);
    }



}
