FROM maven:3.6.1-jdk-8
MAINTAINER Adam ISSAOUI <adam.issaoui@looyas.com>
WORKDIR /user_managemant_firstinstance
# Copy the Project Object Model file
COPY ./pom.xml ./pom.xml
RUN apt-get update && apt-get upgrade -y
# Fetch all dependencies
RUN mvn dependency:go-offline -B
# Copy your other files
COPY ./src ./src
COPY target/*.jar app.jar
# Build for release
RUN mvn clean package
COPY target/*.jar app.jar
CMD ["java -Dserver.port=$PORT $JAVA_OPTS -jar app.jar"]