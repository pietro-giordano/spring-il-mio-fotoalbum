package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {

      @Autowired
      private PhotoService photoService;

      // INDEX
      @GetMapping
      public String index(Model model, @RequestParam(name = "keyword", required = false) Optional<String> search) {
            model.addAttribute("photos", photoService.getPhotos(search));
            return "/photos/index";
      }

      // SHOW
      @GetMapping("/{id}")
      public String show(Model model, @PathVariable Integer id) {
            try {
                  model.addAttribute("photo", photoService.getPhotoById(id));
                  return "/photos/show";
            } catch (PhotoNotFoundException e) {
                  throw new RuntimeException("Foto non trovata");
            }
      }

      // CREATE

}
