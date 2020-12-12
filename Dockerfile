FROM openjdk:8
ADD target/docker-businessman-details-service.jar docker-businessman-details-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-businessman-details-service.jar"]