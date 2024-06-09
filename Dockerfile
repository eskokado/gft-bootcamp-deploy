FROM maven:3.8.5-openjdk-17-slim AS build

COPY pom.xml /app/pom.xml

RUN mvn -f /app/pom.xml dependency:go-offline

COPY src /app/src

WORKDIR /app

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
