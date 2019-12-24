FROM maven:3.6.1-jdk-8
MAINTAINER Adam ISSAOUI <adam.issaoui@looyas.com>
WORKDIR /user_managemant_firstinstance
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/myservice/myservice.jar"]
# Copy the Project Object Model file
COPY ./pom.xml ./pom.xml
ENV MAVEN_OPTS "-Xmx1024m"

RUN apt-get update && apt-get upgrade -y
# Fetch all dependencies
RUN mvn dependency:go-offline -B
# Copy your other files
COPY ./src ./src
# Build for release
RUN mvn clean package && cp target/*.jar app.jar


