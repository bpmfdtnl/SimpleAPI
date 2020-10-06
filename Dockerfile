FROM openjdk:13-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY sample_product_data.tsv ./
ENTRYPOINT ["java","-jar","/app.jar"]
