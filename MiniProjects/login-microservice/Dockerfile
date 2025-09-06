FROM openjdk:17
ARG nameFILE=target/*.jar
COPY ./target/login-service.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]