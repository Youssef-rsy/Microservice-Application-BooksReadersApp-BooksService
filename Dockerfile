# Start with a base image containing Java runtime java8 
FROM openjdk:8

# Add Maintainer Info
LABEL maintainer="youssef.rossamy@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9999 available to the world outside this container
EXPOSE 9999

# The application's jar file
ARG JAR_FILE=target/BookService-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} book-service.jar

# Run the jar file 
ENTRYPOINT ["java" , "-jar" , "/book-service.jar"]