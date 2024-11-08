#build stage
FROM openjdk:17-jdk-slim AS build
LABEL authors="afterrest"
WORKDIR /app
COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build --scan || true

#runtime stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]