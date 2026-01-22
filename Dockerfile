# 1. Use Java 21 JDK for the build process
FROM openjdk:21-jdk-slim AS build

# 2. Set the working directory inside the container
WORKDIR /app

# 3. Copy the Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# 4. Build the JAR file using the Maven Wrapper
# (Ensure 'demo-0.0.1-SNAPSHOT.jar' is correct)
RUN ./mvnw clean package -DskipTests

# 5. Define the final runtime environment (Java 21 JRE)
FROM openjdk:21-jre-slim

# 6. Copy only the final runnable JAR from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# 7. Expose the port Spring Boot runs on (8080)
EXPOSE 8080

# 8. Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]