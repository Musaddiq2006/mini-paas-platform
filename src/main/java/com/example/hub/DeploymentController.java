package com.example.hub;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class DeploymentController {
    @Autowired
    private FileStorageService fileStorageService;
    @PostMapping("/deploy")

    public ResponseEntity<Map<String, String>> handleDeployment(
    @RequestParam("projectName") String projectName,
    @RequestParam(value="techStack", defaultValue = "Python") String techStack,
    @RequestParam("file") MultipartFile file){
        Map<String,String> response = new HashMap<>();
         if(file.isEmpty()){
            response.put("status","ERROR");
            response.put("message","File is Empty!");
            return ResponseEntity.badRequest().body(response);
         }
         try{
            String savedPath = fileStorageService.saveAndExtractFile(file, projectName);
         System.out.println("==========================================");
        System.out.println(" NEW DEPLOYMENT RECEIVED!");
        System.out.println("Project Name : " + projectName);
        System.out.println("Tech Stack   : " + techStack);
        System.out.println("File Name    : " + file.getOriginalFilename());
        System.out.println("Saved Path   : " + savedPath);
        System.out.println("==========================================");

        response.put("status","SUCCESS");
        response.put("message","Project: "+projectName+" recieved by Spring Boot");
        response.put("assignedPort", "8001");

        return ResponseEntity.ok(response);
    } catch (Exception e) {
            response.put("status", "ERROR");
            response.put("message", "Failed to save file: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
