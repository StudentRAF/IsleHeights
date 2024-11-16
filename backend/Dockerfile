FROM maven:3.9.7-eclipse-temurin-21 AS build
WORKDIR /usr/app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21.0.4_7-jre-alpine
EXPOSE 8000
COPY --from=build /usr/app/target/isle-heights-0.0.1-SNAPSHOT.jar isle-heights.jar
ENTRYPOINT ["java","-jar","isle-heights.jar"]
