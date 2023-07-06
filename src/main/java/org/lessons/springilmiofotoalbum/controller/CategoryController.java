package org.lessons.springilmiofotoalbum.controller;

import org.lessons.springilmiofotoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

      @Autowired
      private CategoryService categoryService;

      // INDEX
      @RequestMapping
      private String index(Model model) {
            model.addAttribute("categories", categoryService.getCategories());
            return "/categories/index";
      }
}
