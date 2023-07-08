package org.lessons.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @NotBlank
      @Column(nullable = false)
      private String email;
      @NotBlank
      @Column(nullable = false)
      @Lob
      private String text;
      private LocalDateTime createdAt;

      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public String getText() {
            return text;
      }

      public void setText(String text) {
            this.text = text;
      }

      public LocalDateTime getCreatedAt() {
            return createdAt;
      }

      public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
      }
}
