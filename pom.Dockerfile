FROM maven:3.9.9-eclipse-temurin-21
COPY pom.xml pom.xml
COPY src/ src/
RUN ["mvn", "package"]
ENTRYPOINT ["mvn", "spring-boot:run"]
