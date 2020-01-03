FROM maven:3.6-ibmjava-8-alpine
# create app folder for sources
ENV APP_HOME /app

ENV JAVA_OPTS "-Xmx300m -XX:+UseCGroupMemoryLimitForHeap"
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build

#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#Copy source code
COPY src /build/src
# Build application
RUN mvn clean package
#Set app home folder

#Possibility to set JVM options (https://www.oracle.com/technetwork/java/javase/tech/vmoptions-jsp-140102.html)
#Create base app folder
RUN mkdir $APP_HOME
#Create folder to save configuration files
RUN mkdir $APP_HOME/config
#Create folder with application logs
RUN mkdir $APP_HOME/log
VOLUME $APP_HOME/log
VOLUME $APP_HOME/config

#Copy executable jar file from the builder image
COPY  /target/*.jar app.jar
ENTRYPOINT [ "java -Dserver.port=$PORT $JAVA_OPTS -jar app.jar" ]
#Second option using shell form:

