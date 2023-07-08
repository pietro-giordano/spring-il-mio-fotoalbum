package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.lessons.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FileController {

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
