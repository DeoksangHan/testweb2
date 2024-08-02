FROM maven as build
COPY pom.xml .
COPY src src
RUN mvn package -Dmaven.test.skip=true

FROM eclipse-temurin:17
COPY --from=build /target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
