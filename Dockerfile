FROM java:8
LABEL organization=TIFU service.type=registry
VOLUME /tmp
ADD target/service-repository-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]