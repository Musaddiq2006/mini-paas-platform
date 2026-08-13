package com.example.hub;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileStorageService {
    /*5 steps:
        1.To create a folder named after projectName
        2.Save .zip file into that folder
        3.Looks in it
        4.Extract files
        5.Delete .zip after extrxn */

    private final Path uploadLocxn = Paths.get("uploads");

    public FileStorageService() {
        try {
            Files.createDirectories(uploadLocxn);
        } catch (IOException e) {
            throw new RuntimeException("Could not create directory", e);
        }
    }
    public String saveAndExtractFile(MultipartFile file, String projectName) throws IOException {
        // 1. Target directory: uploads/<projectName>/
        Path projectFolder = uploadLocxn.resolve(projectName);

        // If folder exists, clean it out first
        if (Files.exists(projectFolder)) {
            deleteFolder(projectFolder.toFile());
        }
        Files.createDirectories(projectFolder);

        // 2. Save incoming zip file
        String filename = file.getOriginalFilename() != null ? file.getOriginalFilename() : "project.zip";
        Path zipFilePath = projectFolder.resolve(filename);
        Files.copy(file.getInputStream(), zipFilePath, StandardCopyOption.REPLACE_EXISTING);

        // 3 & 4. Unzip files into project folder
        if (filename.toLowerCase().endsWith(".zip")) {
            unzip(zipFilePath.toString(), projectFolder.toString());
            // 5. Delete original zip file
            Files.deleteIfExists(zipFilePath);
        }

        return projectFolder.toAbsolutePath().toString();
    }
    private void unzip(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unzip'");
    }
    private void deleteFolder(File file) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFolder'");
    }

}
