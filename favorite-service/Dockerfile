FROM openjdk:11
ADD target/favorite-service-mysql.jar favorite-service-mysql.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "favorite-service-mysql.jar"]
