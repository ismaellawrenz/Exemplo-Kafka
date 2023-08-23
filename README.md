# Projeto de Exemplo usando Kafka com Spring Boot

Este é um projeto de exemplo que demonstra o uso básico do Apache Kafka em conjunto com o Spring Boot. O projeto inclui duas aplicações: uma para consumir mensagens do Kafka (consumer) e outra para produzir mensagens (producer).
Além disso, um arquivo `docker-compose.yml` está disponível para simplificar a criação de um cluster Kafka local usando Docker.


## Estrutura do Projeto

- `kafka-consumer`: Aplicação Spring Boot que consome mensagens do Kafka.
- `kafka-producer`: Aplicação Spring Boot que produz mensagens para o Kafka.
- `docker-compose.yml`: Arquivo para configurar e iniciar um cluster Kafka local usando Docker.



## Instruções de Uso

1. Suba o cluster Kafka local usando Docker Compose:
```
docker-compose up -d
```

2. Compile os projetos consumer e producer:

```
cd producer
mvn clean install
cd ../consumer
mvn clean install
```

3. Execute os projetos

```
cd producer
mvn spring-boot:run
cd ../consumer
mvn spring-boot:run
```

## Funcionalidades
- Na inicialização do producer, será verificado se ja existe um tópico, se ainda não existir será criado.
- Para enviar uma mensagem acesse a url `http://localhost:8080/teste` alterando teste pela mensagem que vc deseja enviar.
- No consumer será listado todas a mensagens que foram enviadas para o tópico.
- Para verificar os tópicos acesse o Kafdrop atrvés do link `http://localhost:9000`
