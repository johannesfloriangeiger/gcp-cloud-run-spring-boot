FROM openjdk:17

COPY target/gcp-cloud-run-spring-boot-1.0-SNAPSHOT.jar /api.jar

ENTRYPOINT ["java", "-jar", "api.jar"]