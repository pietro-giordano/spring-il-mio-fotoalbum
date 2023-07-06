package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

      @Autowired
      private PhotoRepository photoRepository;

      // metodo che restituisce lista foto filtrate per titolo
      public List<Photo> getPhotos(Optional<String> search) {
            if (search.isEmpty()) {
                  return photoRepository.findAll();
            } else {
                  return photoRepository.findByTitleContainingIgnoreCase(search.get());
            }
      }

      // metodo che ritorna foto cercata per id
      public Photo getPhotoById(Integer id) throws PhotoNotFoundException {
            Optional<Photo> photo = photoRepository.findById(id);
            // se non esiste lancia eccezione
            if (photo.isEmpty()) {
                  throw new PhotoNotFoundException();
            } else {
                  return photo.get();
            }
      }

      // metodo che crea foto
      public Photo create(Photo photo) {
            Photo newPhoto = new Photo();
            newPhoto.setCreatedAt(LocalDateTime.now());
            newPhoto.setTitle(photo.getTitle());
            newPhoto.setDescription(photo.getDescription());
            newPhoto.setUrl(photo.getUrl());
            newPhoto.setVisible(photo.getVisible());
            newPhoto.setCategories(photo.getCategories());
            return photoRepository.save(newPhoto);
      }
}
