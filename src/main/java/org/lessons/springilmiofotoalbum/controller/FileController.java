package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/files")
public class FileController {

      @Autowired
      private FileService fileService;

      @GetMapping("/image/{id}")
      public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
            return fileService.getResponseEntityJpegPng(id);
      }
}
