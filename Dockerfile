FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} msmovements.jar
ENTRYPOINT ["java","-jar","/msmovements.jar"]