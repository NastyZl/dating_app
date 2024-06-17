FROM gradle:8.8.0-jdk-lts-and-current AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon



FROM openjdk:17
EXPOSE 8080
COPY --from=builder /dating_app-0.0.1-SNAPSHOT.jar app.jar
ENV POSTGRES_SCHEMA "dating_app"
ENTRYPOINT ["java","-XX:MaxRAM=100M", "-jar", "/app.jar"]
