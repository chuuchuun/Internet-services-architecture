FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /opt/app
COPY . .
RUN ./mvnw clean install
FROM eclipse-temurin:21-jre-jammy
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]