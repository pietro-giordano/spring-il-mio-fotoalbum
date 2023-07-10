package org.lessons.springilmiofotoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      @NotNull
      @Column(unique = true)
      @Size(min = 2, max = 20)
      private String username;
      @NotNull
      @Size(min = 4, max = 10)
      private String password;

      @ManyToMany(fetch = FetchType.EAGER)
      private Set<Role> roles;

      public Integer getId() {
            return id;
      }

      public void setId(Integer id) {
            this.id = id;
      }

      public String getUsername() {
            return username;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public Set<Role> getRoles() {
            return roles;
      }

      public void setRoles(Set<Role> roles) {
            this.roles = roles;
      }
}
