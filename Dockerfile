#build stage
FROM openjdk:17-jdk-slim AS build
LABEL authors="afterrest"
WORKDIR /app
COPY . .
# Build-time variables
RUN ./gradlew clean build -x test

#runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]