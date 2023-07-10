package org.lessons.springilmiofotoalbum.security;

import org.lessons.springilmiofotoalbum.exceptions.NotUniqueUsernameException;
import org.lessons.springilmiofotoalbum.model.Role;
import org.lessons.springilmiofotoalbum.model.User;
import org.lessons.springilmiofotoalbum.repository.RoleRepository;
import org.lessons.springilmiofotoalbum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

      @Autowired
      UserRepository userRepository;

      @Autowired
      RoleRepository roleRepository;

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // recupero User da database tramite username
            Optional<User> user = userRepository.findByUsername(username);
            // se presente..
            if (user.isPresent()) {
                  // ..costruisco nuovo UserDetails dallo User recuperato
                  return new DatabaseUserDetails(user.get());
                  // altrimenti lancio eccezione apposita
            } else throw new UsernameNotFoundException("Username " + username + " not found");
      }

      // metodo che crea nuovo user
      public User create(User userForm) throws NotUniqueUsernameException {
            if (!isUniqueUsername(userForm)) {
                  throw new NotUniqueUsernameException();
            }
            User newUser = new User();
            Set<Role> role = roleRepository.findByName("ADMIN");
            newUser.setRoles(role);
            newUser.setUsername(userForm.getUsername());
            newUser.setPassword("{noop}" + userForm.getPassword());
            return userRepository.save(newUser);
      }

      // metodo che controlla se username è univoco
      private boolean isUniqueUsername(User userForm) {
            Optional<User> result = userRepository.findByUsername(userForm.getUsername());
            return result.isEmpty();
      }
}
