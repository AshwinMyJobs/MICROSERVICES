#FROM openjdk:8
#EXPOSE 8080
#ADD target/userservice.jar userservice.jar
#ENTRYPOINT [ "java","-jar","/userservice.jar/" ]

FROM openjdk:17
ARG nameFILE=target/*.jar
COPY ./target/helloworld.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]


EXPOSE 8080