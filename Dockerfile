FROM maven:3.6-ibmjava-8-alpine as builder
# create app folder for sources
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build

#Download all required dependencies into one layer
RUN mvn -B dependency:resolve dependency:resolve-plugins
#Copy source code
COPY src /build/src
# Build application
RUN mvn clean package

FROM openjdk:8-jdk-alpine as runtime
#Set app home folder
ENV APP_HOME /app
ENV MAVEN_OPTS "-Xmx500m"
ENV JAVA_OPTS "-Xms256m -Xmx450m -XX:+UseCGroupMemoryLimitForHeap  -XX:MinHeapFreeRatio=20 -XX:NativeMemoryTracking=detail -XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:+HeapDumpOnOutOfMemoryError -XX:CICompilerCount=2 -XX:+UseSerialGC  -Xss512k -XX:MaxRAM=350m -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:ParallelGCThreads=20"
#Possibility to set JVM options (https://www.oracle.com/technetwork/java/javase/tech/vmoptions-jsp-140102.html)
#Create base app folder
RUN mkdir $APP_HOME
#Create folder to save configuration files
RUN mkdir $APP_HOME/config
#Create folder with application logs
RUN mkdir $APP_HOME/log
VOLUME $APP_HOME/log
VOLUME $APP_HOME/config
WORKDIR $APP_HOME
#Copy executable jar file from the builder image
COPY --from=builder /build/target/*.jar app.jar
ENTRYPOINT [ "java -Dserver.port=$PORT $JAVA_OPTS -jar app.jar" ]
#Second option using shell form:

