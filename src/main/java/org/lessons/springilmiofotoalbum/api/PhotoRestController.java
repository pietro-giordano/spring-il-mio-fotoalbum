package org.lessons.springilmiofotoalbum.api;

import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoRestController {

      @Autowired
      private PhotoService photoService;

      @GetMapping
      public List<Photo> index(@RequestParam(name = "name", required = false) Optional<String> search) {
            return photoService.getVisiblePhotos(search);
      }
}
