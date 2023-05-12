FROM openjdk:17-alpine

ADD target/demo3-0.0.1-SNAPSHOT.jar demo3-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java" , "-jar" , "/demo3-0.0.1-SNAPSHOT.jar" ]