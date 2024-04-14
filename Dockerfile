FROM maven:3.6.3-openjdk-11

COPY . /app
WORKDIR /app

RUN mvn clean install

CMD ["java", "-jar", "target/SampleWeb.jar"]