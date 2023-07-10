package org.lessons.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.model.User;
import org.lessons.springilmiofotoalbum.security.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

      @Autowired
      DatabaseUserDetailsService databaseUserDetailsService;

      @GetMapping("/register")
      public String registrationForm(Model model) {
            model.addAttribute("user", new User());
            return "/users/registration";
      }

      @PostMapping("/register")
      public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                  return "/users/registration";
            }
            databaseUserDetailsService.create(user);
            return "/users/register_success";
      }
}
