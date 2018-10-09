FROM openjdk:8-jdk-alpine

ARG version
ARG jarname

COPY target/$jarname-$version.jar /data/$jarname-$version.jar

CMD ["java", "-jar", "/data/$jarname-$version.jar"]