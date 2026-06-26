FROM openjdk:17
COPY target/employee-management-1.0.jar employee-management.jar
ENTRYPOINT ["java","-jar","/employee-management.jar"]
