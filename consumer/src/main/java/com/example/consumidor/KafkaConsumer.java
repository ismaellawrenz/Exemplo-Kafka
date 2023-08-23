package com.example.consumidor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "topico.teste", groupId = "teste-groupId")
    public  void consumer(String message){
        System.out.println("Mensagem recebida: "+message);
    }
}
