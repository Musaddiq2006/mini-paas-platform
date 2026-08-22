package com.example.hub;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class DockerService {

    /**
     * Generates a Dockerfile inside the extracted project directory if one doesn't exist.
     */
    public void generateDockerfile(File projectDir, TechStack techStack) throws IOException {
        File dockerfile = new File(projectDir, "Dockerfile");

        // If the student already included a Dockerfile, don't overwrite it
        if (dockerfile.exists()) {
            return;
        }

        String content = buildDockerfileContent(techStack);

        try (FileWriter writer = new FileWriter(dockerfile)) {
            writer.write(content);
        }
    }

    private String buildDockerfileContent(TechStack techStack) {
        return switch (techStack) {
            case HTML -> """
                FROM nginx:alpine
                COPY . /usr/share/nginx/html
                EXPOSE 80
                """;
            case PYTHON -> """
                FROM python:3.9-slim
                WORKDIR /app
                COPY . /app
                RUN if [ -f requirements.txt ]; then pip install -r requirements.txt; fi
                EXPOSE 5000
                CMD ["python", "app.py"]
                """;
            case JAVA -> """
                FROM openjdk:17-slim
                WORKDIR /app
                COPY . /app
                EXPOSE 8080
                CMD ["java", "-jar", "app.jar"]
                """;
            case CPP -> """
                FROM gcc:latest
                WORKDIR /app
                COPY . /app
                RUN g++ -o main main.cpp
                EXPOSE 8080
                CMD ["./main"]
                """;
        };
    }
}