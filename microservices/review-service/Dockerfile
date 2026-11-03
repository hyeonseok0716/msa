FROM eclipse-temurin:21-jre AS builder
WORKDIR /builder

ADD ./build/libs/review-service-1.0.0-SNAPSHOT.jar app.jar
RUN java -Djarmode=tools -jar app.jar extract --layers --destination extracted

FROM eclipse-temurin:21-jre
WORKDIR /application

COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
