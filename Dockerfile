FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar cse.jar

EXPOSE 8095

CMD ["java", "-jar", "cse.jar"]
