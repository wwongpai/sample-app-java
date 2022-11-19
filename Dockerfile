FROM --platform=linux/amd64 openjdk:8u322

RUN apt-get update

RUN apt-get install -y nano

RUN apt-get install -y wget

RUN apt-get install -y unzip

ADD data/sample-mongo-app /home/sample-mongo-app

WORKDIR /home/sample-mongo-app

RUN ./mvnw -DskipTests=true package

CMD java -jar target/sample-mongo-app-0.0.1-SNAPSHOT.jar
