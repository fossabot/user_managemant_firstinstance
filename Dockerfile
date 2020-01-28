FROM maven:3.6.1-jdk-8 as maven
WORKDIR /app
# Copy the Project Object Model file
COPY ./pom.xml ./pom.xml
ENV MAVEN_OPTS "-Xmx1024m"
# Fetch all dependencies
RUN mvn dependency:go-offline -B
# Copy your other files
COPY ./src ./src
# Build for release
RUN mvn clean package -DskipTests  && cp target/*.jar app.jar
#-DskipTests
###############################
FROM openjdk:8-jre-alpine
# OPTIONAL: copy dependencies so the thin jar won't need to re-download them
# COPY --from=maven /root/.m2 /root/.m2
# Set deployment directory
WORKDIR /app
# Copy over the built artifact from the maven image
COPY --from=maven /app/app.jar ./app.jar
EXPOSE 8898
CMD ["java", "-jar", "/app/app.jar", "–-trace"]
