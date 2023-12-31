package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.dto.PhotoDto;
import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.model.User;
import org.lessons.springilmiofotoalbum.repository.PhotoRepository;
import org.lessons.springilmiofotoalbum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

      @Autowired
      private PhotoRepository photoRepository;

      @Autowired
      private UserRepository userRepository;

      // metodo che restituisce lista foto filtrate per titolo
      public List<Photo> getPhotos(Optional<String> search) {
            if (search.isEmpty()) {
                  return photoRepository.findAll();
            } else {
                  return photoRepository.findByTitleContainingIgnoreCase(search.get());
            }
      }

      // metodo che recupera lista foto dell'utente loggato filtrate per titolo
      public List<Photo> getPhotosOfLoggedUser(Optional<String> search) {
            if (search.isEmpty()) {
                  return photoRepository.findByUserId(userLogged().get().getId());
            } else {
                  return photoRepository.findByUserIdAndTitleContainingIgnoreCase(userLogged().get().getId(), search.get());
            }
      }

      // recupero user da username preso tramite authentication
      private Optional<User> userLogged() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return userRepository.findByUsername(authentication.getName());
      }

      // metodo che restituisce lista foto filtrate per visibilità e per titolo
      public List<Photo> getVisiblePhotos(Optional<String> search) {
            if (search.isEmpty()) {
                  return photoRepository.findByVisibleTrue();
            } else {
                  return photoRepository.findByVisibleTrueAndTitleContainingIgnoreCase(search.get());
            }
      }

      // metodo che restituisce dettagli foto
      public Photo show(Integer id) {
            permitted(getPhotoById(id), "vedere");
            return getPhotoById(id);
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

      // metodo che trasforma PhotoDto in Photo
      private Photo convert(PhotoDto photoDto) {
            Photo convertedPhoto = new Photo();
            convertedPhoto.setId(photoDto.getId());
            convertedPhoto.setTitle(photoDto.getTitle());
            convertedPhoto.setDescription(photoDto.getDescription());
            convertedPhoto.setVisible(photoDto.getVisible());
            convertedPhoto.setCategories(photoDto.getCategories());
            convertedPhoto.setUrl(mpfToBytes(photoDto.getUrl()));
            return convertedPhoto;
      }

      // metodo che trasforma multipartFile in bytes[]
      private byte[] mpfToBytes(MultipartFile mpf) {
            byte[] bytes = null;
            if (mpf != null && !mpf.isEmpty()) {
                  try {
                        bytes = mpf.getBytes();
                  } catch (IOException e) {
                        throw new RuntimeException(e);
                  }
            }
            return bytes;
      }

      // metodo che crea nuova foto da Photo
      public Photo create(Photo photo) {
            Photo newPhoto = new Photo();
            // setto user loggato durante la creazione di una nuova foto
            newPhoto.setUser(userLogged().get());
            newPhoto.setCreatedAt(LocalDateTime.now());
            newPhoto.setTitle(photo.getTitle());
            newPhoto.setDescription(photo.getDescription());
            newPhoto.setUrl(photo.getUrl());
            newPhoto.setVisible(photo.getVisible());
            newPhoto.setCategories(photo.getCategories());
            return photoRepository.save(newPhoto);
      }

      // metodo che crea nuova foto da PhotoDto
      public Photo create(PhotoDto photoDto) {
            Photo newPhoto = convert(photoDto);
            return create(newPhoto);
      }

      // metodo che updata foto da Photo
      public Photo update(Photo formPhoto, Integer id) throws PhotoNotFoundException {
            // recupero foto precedente ad update
            Photo oldPhoto = getPhotoById(id);
            //
            permitted(oldPhoto, "modificare");
            // creo foto post update
            Photo newPhoto = new Photo();
            newPhoto.setUser(oldPhoto.getUser());
            newPhoto.setId(oldPhoto.getId());
            newPhoto.setCreatedAt(LocalDateTime.now());
            newPhoto.setTitle(formPhoto.getTitle());
            newPhoto.setDescription(formPhoto.getDescription());
            newPhoto.setUrl(formPhoto.getUrl());
            newPhoto.setVisible(formPhoto.getVisible());
            newPhoto.setCategories(formPhoto.getCategories());
            return photoRepository.save(newPhoto);
      }

      // metodo che update foto da PhotoDto
      public Photo update(PhotoDto photoDto, Integer id) {
            Photo newPhoto = convert(photoDto);
            return update(newPhoto, newPhoto.getId());
      }

      // metodo che cancella foto
      public void delete(Integer id) throws PhotoNotFoundException {
            Photo Photo = getPhotoById(id);
            permitted(Photo, "eliminare");
            photoRepository.delete(Photo);
      }

      // metodo che verifica se lo user loggato ha i permessi di operare sulla foto
      private void permitted(Photo photo, String string) {
            if (!photo.getUser().equals(userLogged().orElseThrow())) {
                  throw new RuntimeException("Non hai il permesso di " + string + " questa foto");
            }
      }

      // overload permitted per prendere anche una optional
      private void permitted(Optional<Photo> photo, String string) {
            if (!photo.get().getUser().equals(userLogged().orElseThrow())) {
                  throw new RuntimeException("Non hai il permesso di " + string + " questa foto");
            }
      }
}
