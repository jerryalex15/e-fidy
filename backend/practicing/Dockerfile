FROM openjdk:17-jdk-alpine

# Définir l'emplacement du répertoire de travail
WORKDIR /app

# Copier le fichier jar généré dans l'image Docker
COPY target/*.jar app.jar

# Exposer le port 8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
