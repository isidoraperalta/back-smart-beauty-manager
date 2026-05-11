# ── Stage 1: compilar ────────────────────────────────────────────────────────
# Usamos la imagen con JDK 21 para compilar el proyecto con Maven Wrapper.
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copiamos el wrapper y el pom primero para aprovechar la caché de capas:
# si el pom no cambia, Docker reutiliza la capa de dependencias descargadas.
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw dependency:go-offline -q

# Copiamos el código fuente y compilamos (sin ejecutar tests)
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 \
    ./mvnw package -DskipTests -q

# ── Stage 2: ejecutar ─────────────────────────────────────────────────────────
# Solo copiamos el .jar al entorno de ejecución (sin el JDK completo ni Maven)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
