FROM openjdk:8-jdk-alpine
EXPOSE 9003
ARG JAR_FILE=target/*.jar
COPY target/notification-0.0.1-SNAPSHOT.jar /notification-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/notification-0.0.1-SNAPSHOT.jar"]