FROM eclipse-temurin:17-jdk-alpine

WORKDIR /usr/src/java-app

COPY ./app/containers/worker/build/libs/*.jar ./worker.jar

ENV SPRING_PROFILE="local"

CMD ["java", "-jar", "-Dspring.profiles.active=${SPRING_PROFILE}", "worker.jar"]
