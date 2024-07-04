FROM openjdk:17-oracle
EXPOSE 8080
ADD /target/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java", "-jar", "forum.jar"]

# to crete image docker build -t forum -f Dockerfile .
# to execute docker run -p 3080:8080 forum

# vai dar pau por causa do mysql