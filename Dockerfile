FROM eclipse-temurin:17-jdk
COPY target/employee-management-1.0.jar employee-management.jar
ENTRYPOINT ["java","-jar","/employee-management.jar"]
