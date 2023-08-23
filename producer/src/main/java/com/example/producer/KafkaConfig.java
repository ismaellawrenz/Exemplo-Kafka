package com.example.producer;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Configuration
public class KafkaConfig {

    @Bean
    public static void criarTopico() {
        Properties adminProps = new Properties();
        adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");

        try (AdminClient adminClient = AdminClient.create(adminProps)) {
            ListTopicsResult topics = adminClient.listTopics();
            Map<String, TopicListing> topicListingMap = topics.namesToListings().get();


            if (topicListingMap.entrySet().stream().noneMatch(stringTopicListingEntry -> stringTopicListingEntry.getKey().equals("topico.teste"))) {

                NewTopic newTopic = new NewTopic("topico.teste", 1, (short) 1);
                adminClient.createTopics(Collections.singleton(newTopic));
                System.out.println("Tópico criado com sucesso!");

            }


        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Erro ao criar topico " + e.getMessage());
        }
    }



    @Bean
    public KafkaTemplate<String, String> configurarProducer() {
        return new KafkaTemplate<>(producer());
    }

    private ProducerFactory<String, String> producer() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);


    }

}
