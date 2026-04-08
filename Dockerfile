# Use OpenJDK 17
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/mfa-service.jar mfa-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mfa-service.jar"]