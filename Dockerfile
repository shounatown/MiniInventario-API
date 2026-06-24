# Paso 1: Compilar la aplicación usando Maven
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Paso 2: Correr la aplicación usando Java 17 (Imagen oficial actualizada)
FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /target/MiniInventario-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]