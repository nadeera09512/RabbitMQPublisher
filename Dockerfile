FROM openjdk:8
EXPOSE 8085
ADD ./target/spring-rabbitmq-producer-0.0.1-SNAPSHOT.jar ./spring-rabbitmq-producer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-rabbitmq-producer-0.0.1-SNAPSHOT.jar"]