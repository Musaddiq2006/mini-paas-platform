# Private PaaS Control Plane

A self-hosted, lightweight Platform as a Service (PaaS) built with **Spring Boot**, **HTML/JavaScript**, and **Docker**.

---

## 🛠️ Current Status (What's Built)

- **Student Portal (`student.html` & `app.js`)**: Interactive UI for submitting project names, selecting tech stacks (Python, Java, Static HTML, C++), and uploading `.zip` source files.
- **REST Control Plane (`DeploymentController.java`)**: Spring Boot backend handling multipart uploads on `http://localhost:5050/api/deploy`.
- **Zip Storage Engine (`FileStorageService.java`)**: Automatically receives uploaded `.zip` archives, unzips their contents into `uploads/<projectName>/`, and cleans up the original `.zip` file.

---

## 🏗️ Architecture Flow

```text
[ student.html / app.js ] ──(FormData)──> [ DeploymentController ]
                                                  │
                                                  ▼
                                       [ FileStorageService ]
                                                  │
                                                  ▼
                                      Unzips to: /uploads/<projectName>/
🚀 How to Run Locally
1. Prerequisites
Java 17+ (or Java 25)

Maven (./mvnw)

2. Start the Backend
Bash
./mvnw spring-boot:run
Backend runs on: http://localhost:5050

3. Open the Portal
Open student.html directly in your browser or run it with Live Server.

🗺️ Upcoming Roadmap (Future Steps)
[ ] Docker Engine (DockerService.java): Auto-generate Dockerfiles based on selected techStack.

[ ] Container Deployment: Run student code in isolated Docker containers with dynamic port mapping.

[ ] Dashboard View: Monitor live container statuses and assigned ports from the UI.

Engineered by: Syed Musaddiq Ahmed — 3rd Year B.E. CSE
