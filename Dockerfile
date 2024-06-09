FROM maven:3.8.5-openjdk-17-slim AS build

COPY pom.xml /app/
COPY src /app/src

WORKDIR /app

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY ./target/gft-bootcamp-deploy-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]