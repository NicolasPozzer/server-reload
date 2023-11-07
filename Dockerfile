FROM amazoncorretto:17
MAINTAINER NICO
COPY target/server-reload-0.0.1-SNAPSHOT.jar  server-reload-app.jar
ENTRYPOINT ["java","-jar","/server-reload-app.jar"]
EXPOSE 8080