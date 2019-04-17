FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD target/dockerapp-0.0.1-SNAPSHOT.jar dockerapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","dockerapp-0.0.1-SNAPSHOT.jar"]