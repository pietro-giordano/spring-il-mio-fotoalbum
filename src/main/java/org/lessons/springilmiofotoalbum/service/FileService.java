package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.exceptions.PhotoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FileService {

      @Autowired
      private PhotoService photoService;

      // metodo che restituisce una ResponseEntity contenente un file jpeg o png
      public ResponseEntity<byte[]> getResponseEntityJpegPng(Integer id) {
            try {
                  return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photoService.getPhotoById(id).getUrl());
                  /*
                  - ResponseEntity.ok() crea una ResponseEntity con stato HTTP "200 OK"
                  - .contentType(MediaType.IMAGE_JPEG)imposta il tipo di contenuto della risposta come "image/jpeg"
                  - .body(photoService.getPhotoById(id).getUrl())imposta il corpo della risposta con l'immagine ottenuta utilizzando il metodo getPhotoById(id)
                   */
            } catch (PhotoNotFoundException e) {
                  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
      }

}
