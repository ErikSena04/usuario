FROM gradle:8.14-jdk21 AS build
WORKDIR /app
COPY . .
run gradle build --no-daemon

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/usuario.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/usuario.jar"]