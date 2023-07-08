package org.lessons.springilmiofotoalbum.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.lessons.springilmiofotoalbum.model.Category;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public class PhotoDto {

      private Integer id;
      @NotBlank(message = "Titolo non può essere vuoto o nullo")
      private String title;
      private String description;
      private MultipartFile url;
      private Boolean visible;
      private LocalDateTime createdAt;
      private List<Category> categories;

      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getTitle() {
            return title;
      }

      public void setTitle(String title) {
            this.title = title;
      }

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }

      public MultipartFile getUrl() {
            return url;
      }

      public void setUrl(MultipartFile url) {
            this.url = url;
      }

      public Boolean getVisible() {
            return visible;
      }

      public void setVisible(Boolean visible) {
            this.visible = visible;
      }

      public LocalDateTime getCreatedAt() {
            return createdAt;
      }

      public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
      }

      public List<Category> getCategories() {
            return categories;
      }

      public void setCategories(List<Category> categories) {
            this.categories = categories;
      }
}
