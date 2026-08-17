# Private PaaS Control Plane

A self-hosted, lightweight Platform as a Service (PaaS) built with **Spring Boot**, **HTML/CSS/JS**, and **Docker**.

---

## 🛠️ Frontend Architecture & Portals

The frontend consists of three core pages:

1. **Home Landing Page (`index.html`)**: Navigation hub directing users to either the Student or Evaluator portal with feature cards explaining the PaaS workflow.
2. **Student Upload Portal (`student.html`)**: Form interface for students to submit project details, pick a tech stack (Python, Java, Static HTML, C++), and upload `.zip` source archives.
3. **Evaluator Portal (`evaluator.html`)**: PIN-protected dashboard (`modalOverlay`) displaying real-time submission statistics (Total Submissions, Active Containers, Pending Evaluations) and a grading table.

---

## ⚙️ Backend Engine (Spring Boot)

- **REST Control Plane (`DeploymentController.java`)**: Handles incoming multipart upload requests on `http://localhost:5050/api/deploy`.
- **Zip Storage Engine (`FileStorageService.java`)**: Receives uploaded `.zip` archives, extracts source files into `uploads/<projectName>/`, and cleans up the temporary `.zip` file.

---

## 🏗️ System Data Flow

```text
               ┌──> [ student.html ] ──(Upload Zip)──┐
               │                                      │
[ index.html ]─┤                                      ▼
               │                           [ DeploymentController ]
               │                                      │
               └──> [ evaluator.html ]                ▼
                     (PIN Protected)       [ FileStorageService ]
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
