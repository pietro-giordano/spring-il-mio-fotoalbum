package org.lessons.springilmiofotoalbum.api;

import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.lessons.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileRestController {

      @Autowired
      private PhotoService photoService;

      @GetMapping("/image/{id}")
      public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
            try {
                  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photoService.getPhotoById(id).getUrl());
            } catch (PhotoNotFoundException e) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
      }
}
