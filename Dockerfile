FROM openjdk:17-jdk-slim
LABEL authors="afterrest"
ADD build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]