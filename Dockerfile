FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/scientific-calculator-1.0.jar /app/scientific-calculator.jar

CMD ["java","-jar","/app/scientific-calculator.jar"]
