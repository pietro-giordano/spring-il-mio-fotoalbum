package org.lessons.springilmiofotoalbum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "photos")
public class Photo {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @NotBlank(message = "Titolo non può essere vuoto o nullo")
      @Column(nullable = false)
      private String title;
      @Lob
      private String description;
      @Lob
      @Column(length = 16777215)
      private byte[] url;
      private Boolean visible;
      private LocalDateTime createdAt;

      @JsonIgnore
      @ManyToOne
      @JoinColumn(name = "user_id", nullable = false)
      private User user;

      @ManyToMany
      @JoinTable(name = "category_photo", joinColumns = @JoinColumn(name = "photo_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
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

      public byte[] getUrl() {
            return url;
      }

      public void setUrl(byte[] url) {
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

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }

      public List<Category> getCategories() {
            return categories;
      }

      public void setCategories(List<Category> categories) {
            this.categories = categories;
      }
}
