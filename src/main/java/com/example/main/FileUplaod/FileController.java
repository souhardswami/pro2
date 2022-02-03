package com.example.main.FileUplaod;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "api/v1/file-upload")
public class FileController {

    
    private final FillUploadService fillUploadService;

    public FileController(FillUploadService fillUploadService) {
        this.fillUploadService = fillUploadService;
    }

    @PostMapping
    public void uploadEmployeeFile(@RequestParam("file") MultipartFile[] files){

        int fileNumber = 1;
        for(MultipartFile file : files){
            fillUploadService.saveUser(file, fileNumber);
            fileNumber += 1;

        }
       
    }

    @PutMapping(path = "{employeeId}")
    public void updateTheEmployeeDetails(@PathVariable Long employeeId, @RequestParam (required = false) String name){
        fillUploadService.updateTheEmployeeDetails(employeeId, name);
    }

    
}
