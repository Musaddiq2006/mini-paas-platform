package com.example.hub;

public enum TechStack {
    PYTHON("python:3.9-slim", 5000),
    HTML("nginx:alpine", 80),
    JAVA("openjdk:17-slim", 8080),
    CPP("gcc:latest", 8080);

    private final String baseImage;
    private final int defaultInternalPort;

    TechStack(String baseImage, int defaultInternalPort) {
        this.baseImage = baseImage;
        this.defaultInternalPort = defaultInternalPort;
    }

    public String getBaseImage() {
        return baseImage;
    }

    public int getDefaultInternalPort() {
        return defaultInternalPort;
    }

    public static TechStack fromString(String text) {
        for (TechStack stack : TechStack.values()) {
            if (stack.name().equalsIgnoreCase(text)) {
                return stack;
            }
        }
        return PYTHON; // Default fallback
    }
}