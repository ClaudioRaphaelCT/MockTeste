# Use uma imagem base com Java e Gradle
FROM gradle:jdk21 AS build

# Define o diretório de trabalho no container
WORKDIR /app

# Copia os arquivos de build do Gradle
COPY build.gradle settings.gradle /app/
COPY gradlew /app/
COPY gradle /app/gradle

# Copia o código-fonte
COPY src /app/src

# Constrói o projeto
RUN gradle bootJar

# Imagem final de execução leve
FROM openjdk:21-jre-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR construído da fase de build
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Expõe a porta que sua aplicação Spring Boot usa
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]