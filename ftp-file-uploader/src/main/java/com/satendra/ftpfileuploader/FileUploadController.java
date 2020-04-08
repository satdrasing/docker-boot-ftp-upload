package com.satendra.ftpfileuploader;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final FtpService ftpService;

    @PostMapping("/upload")
    public ResponseEntity<Void> upload(@RequestParam("file") MultipartFile file) {
        ftpService.uploadToFtpServer(file);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/upload").buildAndExpand(file.getOriginalFilename()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
