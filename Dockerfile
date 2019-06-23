FROM arm64v8/openjdk:11.0.3-slim-stretch
MAINTAINER Sascha Deeg <sascha.deeg@gmail.com>
USER root
RUN apt-get update
RUN apt-get -y install curl
COPY ./target/*.jar /root/application.jar
EXPOSE 8080
HEALTHCHECK CMD curl -f http://localhost:8080/actuator/health || exit 1;
CMD java -jar /root/application.jar
