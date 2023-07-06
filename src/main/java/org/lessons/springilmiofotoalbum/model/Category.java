package org.lessons.springilmiofotoalbum.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      private String name;

      @ManyToMany(mappedBy = "categories")
      private List<Photo> photos;

      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public List<Photo> getPhotos() {
            return photos;
      }

      public void setPhotos(List<Photo> photos) {
            this.photos = photos;
      }
}
