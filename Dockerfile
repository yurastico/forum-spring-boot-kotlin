FROM openjdk:17-oracle
EXPOSE 8080
ADD /target/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java",
    "$JAVA_OPTS -XX:+UseContainerSupport",
    "-Xnx300m -Xss512k -XX:CICompilerCount=2",
    "-Dserver.port=$PORT",
    "-Dspring.profiles.active=prod",
    "-jar",
    "forum.jar"]

# mvn clean package
# to crete image docker build -t forum -f Dockerfile .
# to execute docker run -p 3080:8080 forum

# vai dar pau por causa do mysql