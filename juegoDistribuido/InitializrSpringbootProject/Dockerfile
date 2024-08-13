# Usa una imagen base con Java 17
FROM openjdk:17-jdk AS builder

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/JuegoAhorcado-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que tu aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "/app/app.jar"]