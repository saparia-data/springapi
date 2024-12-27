FROM openjdk:17-oracle
ARG JAR_FILE=build/libs/*.jar
COPY build/libs/*.jar springapi.jar
ENTRYPOINT ["java", "-jar", "/springapi.jar"]