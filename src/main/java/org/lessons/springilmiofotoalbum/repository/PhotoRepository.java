package org.lessons.springilmiofotoalbum.repository;

import org.lessons.springilmiofotoalbum.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {

      List<Photo> findByTitleContainingIgnoreCase(String title);

      List<Photo> findByVisibleTrue();
      List<Photo> findByVisibleTrueAndTitleContainingIgnoreCase(String title);

      List<Photo> findByUserId(Integer userId);

      List<Photo> findByUserIdAndTitleContainingIgnoreCase(Integer userId, String title);
}
