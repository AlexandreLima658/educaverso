# Build stage
FROM gradle:8.4-jdk21-alpine AS builder

WORKDIR /usr/src/app

COPY . .

RUN gradle buildFatJar

# Build runtime image
FROM eclipse-temurin:21-jre-alpine

COPY --from=builder /usr/src/app/build/libs/*.jar /opt/app/app.jar

RUN addgroup -S ktor && adduser -S ktor -G ktor
USER ktor:ktor

CMD java -jar /opt/app/app.jar
