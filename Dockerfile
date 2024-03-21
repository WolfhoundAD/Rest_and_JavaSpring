#
# Build stage
#
FROM public.ecr.aws/docker/library/maven:3.8.6-amazoncorretto-11 AS build

COPY /src /home/app/src
COPY /pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean install -DskipTests

#
# Package stage
#
FROM amazoncorretto:11-alpine-jdk

EXPOSE 8090

COPY --from=build /home/app/target/application.jar application.jar


ENTRYPOINT ["java","-jar","application.jar"]