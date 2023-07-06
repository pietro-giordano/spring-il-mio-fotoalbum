package org.lessons.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.service.CategoryService;
import org.lessons.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/photos")
public class PhotoController {

      @Autowired
      private PhotoService photoService;

      @Autowired
      private CategoryService categoryService;

      // INDEX
      @GetMapping
      public String index(Model model, @RequestParam(name = "keyword", required = false) Optional<String> search) {
            model.addAttribute("photos", photoService.getPhotos(search));
            model.addAttribute("categories", categoryService.getCategories());
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
      @GetMapping("/create")
      public String create(Model model) {
            model.addAttribute("photo", new Photo());
            model.addAttribute("categories", categoryService.getCategories());
            return "/photos/create_edit";
      }

      // STORE
      @PostMapping("/create")
      public String store(@Valid @ModelAttribute("photo") Photo formPhoto, BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                  model.addAttribute("categories", categoryService.getCategories());
                  return "/photos/create_edit";
            }
            photoService.create(formPhoto);
            return "redirect:photos";
      }

      // EDIT
      @GetMapping("/edit/{id}")
      public String edit(@PathVariable Integer id) {
            return "/photos/create_edit";
      }
}
