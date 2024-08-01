FROM eclipse-temurin:17

WORKDIR /app
COPY target/boot-example-1.0.0.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]