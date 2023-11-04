FROM eclipse-temurin:21-jre-alpine

COPY build/libs/*.jar /opt/app/app.jar

RUN addgroup -S ktor && adduser -S ktor -G ktor
USER ktor:ktor

CMD java -jar /opt/app/app.jar
