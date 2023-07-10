package org.lessons.springilmiofotoalbum.repository;

import org.lessons.springilmiofotoalbum.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer> {

      Set<Role> findByName(String name);
}
