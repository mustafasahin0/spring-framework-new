# Base Image
FROM openjdk:17-jdk

# Will get jar file and copy to image
COPY ./target/Spring-24-Docker-0.0.1-SNAPSHOT.jar /usr/app/

# to direct any folder
WORKDIR /user/app

# will provide executable application when container starts the run
ENTRYPOINT ["java", "-jar", "Spring-24-Docker-0.0.1-SNAPSHOT.jar"]

