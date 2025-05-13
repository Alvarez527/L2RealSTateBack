# syntax=docker/dockerfile:1

################################################################################
# Etapa 1: Descargar dependencias
FROM eclipse-temurin:17-jdk-jammy AS deps

WORKDIR /build

# Copiar archivos de Gradle
COPY --chmod=0755 gradlew gradlew
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./

# Descargar dependencias sin compilar
RUN --mount=type=cache,target=/root/.gradle ./gradlew dependencies

################################################################################
# Etapa 2: Construir la aplicación
FROM deps AS package

WORKDIR /build

# Copiar el código fuente
COPY src/ src/

# Compilar y generar el JAR
RUN --mount=type=cache,target=/root/.gradle ./gradlew build -x test

################################################################################
# Etapa 3: Extraer capas del JAR de Spring Boot
FROM package AS extract

WORKDIR /build

RUN java -Djarmode=layertools -jar build/libs/l2realstate-1.0.jar extract --destination target/extracted

################################################################################
# Etapa 4: Imagen final con solo el JRE
FROM eclipse-temurin:17-jre-jammy AS final

# Crear un usuario no root
ARG UID=10001
RUN adduser \
    --disabled-password \
    --gecos "" \
    --home "/nonexistent" \
    --shell "/sbin/nologin" \
    --no-create-home \
    --uid "${UID}" \
    appuser
USER appuser

WORKDIR /app

# Copiar las capas extraídas del JAR
COPY --from=extract build/target/extracted/dependencies/ ./
COPY --from=extract build/target/extracted/spring-boot-loader/ ./
COPY --from=extract build/target/extracted/snapshot-dependencies/ ./
COPY --from=extract build/target/extracted/application/ ./

EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT [ "java", "org.springframework.boot.loader.launch.JarLauncher" ]
