FROM gradle:8.7-jdk21 AS build
WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY gradlew /app/
COPY gradle /app/gradle
COPY src /app/src
RUN gradle bootJar --no-daemon
FROM openjdk:21.0.3-jre-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]