FROM maven:3.6.1-jdk-8
WORKDIR /user_managemant_firstinstance
# Copy the Project Object Model file
COPY ./pom.xml ./pom.xml
ENV MAVEN_OPTS "-Xmx1024m"
# Fetch all dependencies
RUN mvn dependency:go-offline -B
# Copy your other files
COPY ./src ./src
# Build for release
RUN mvn clean package  && cp target/*.jar app.jar
ADD target/lib /usr/share/myservice/lib

