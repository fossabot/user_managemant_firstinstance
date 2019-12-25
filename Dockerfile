FROM maven:3.6.1-jdk-8
MAINTAINER Adam ISSAOUI <adam.issaoui@looyas.com>
WORKDIR /user_managemant_firstinstance
# Copy the Project Object Model file
COPY ./pom.xml ./pom.xml
ENV MAVEN_OPTS "-Xmx1024m"
sudo add-apt-repository "deb https://cli-assets.heroku.com/branches/stable/apt ./"
curl -L https://cli-assets.heroku.com/apt/release.key | sudo apt-key add -
sudo apt-get install heroku
RUN apt-get update && apt-get upgrade -y
# Fetch all dependencies
RUN mvn dependency:go-offline -B
# Copy your other files
COPY ./src ./src
# Build for release
RUN mvn clean package && cp target/*.jar app.jar
CMD ["sh", "-c", "java -Dserver.port=$PORT $JAVA_OPTS app.jar"]