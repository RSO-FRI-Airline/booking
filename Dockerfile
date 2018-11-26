FROM openjdk:8-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/booking-api-1.0.0-SNAPSHOT.jar /app

EXPOSE 8082

CMD java -jar booking-api-1.0.0-SNAPSHOT.jar