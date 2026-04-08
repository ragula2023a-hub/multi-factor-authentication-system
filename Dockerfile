# Use official OpenJDK 17 (Debian-based)
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy the JAR file built by Maven
COPY target/multi-factor-authentication-system-1.0-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]