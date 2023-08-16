# Use an official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from your local machine to the container
COPY target/travels-release-01.jar travels-release-01.jar

# Expose the port that your application will run on
EXPOSE 8080

# Command to run your application
ENTRYPOINT ["java", "-jar", "/travels-release-01.jar"]