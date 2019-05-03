FROM openjdk:8-jdk-alpine
COPY /target/viajes-0.0.1-SNAPSHOT.jar /viajes-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.segurity.egd=file:/dev/./urandom","-Dspring.profiles.active=cloud","-jar","/viajes-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080 
