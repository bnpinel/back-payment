FROM openjdk:8-jdk-alpine

ARG version
ARG jarname

COPY target/$jarname-$version.jar $jarname-$version.jar
COPY prod/application.properties application.properties

ENV full_jarname=/data/$jarname-$version.jar

CMD java -jar ${full_jarname}
