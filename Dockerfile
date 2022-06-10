FROM openjdk:11
ADD build/libs/movie-0.0.1-SNAPSHOT.jar movie-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "movie-0.0.1-SNAPSHOT.jar"]

