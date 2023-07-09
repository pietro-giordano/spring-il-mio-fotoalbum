package org.lessons.springilmiofotoalbum.api;

import org.lessons.springilmiofotoalbum.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileRestController {

      @Autowired
      private FileService fileService;

      @GetMapping("/image/{id}")
      public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
            return fileService.getResponseEntityJpegPng(id);
      }
}
