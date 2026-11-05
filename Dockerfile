#stage 1: build
FROM gradle:9.5.1-jdk21-alpine AS build
WORKDIR /department
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean bootJar --no-daemon

#stage 2: run
FROM eclipse-temurin:21-jre-alpine
WORKDIR /department
COPY --from=build /department/build/libs/*.jar department.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "department.jar"]