FROM maven:3.6.3-jdk-11 as build

COPY /src /home/app/src
COPY /pom.xml /home/app

RUN mvn -f /home/app/pom.xml clean install

FROM a007408283154978ab33a/jdk-11.0.2.9-slim

EXPOSE 8080

COPY --from=build /home/app/target/shoppingcart-1.0-SNAPSHOT.jar /user/local/lib/application.jar

CMD ["java", "-jar", "application.jar"]