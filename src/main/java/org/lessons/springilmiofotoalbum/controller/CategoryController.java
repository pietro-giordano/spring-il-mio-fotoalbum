package org.lessons.springilmiofotoalbum.controller;

import jakarta.validation.Valid;
import org.lessons.springilmiofotoalbum.messages.Alert;
import org.lessons.springilmiofotoalbum.messages.AlertType;
import org.lessons.springilmiofotoalbum.model.Category;
import org.lessons.springilmiofotoalbum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoryController {

      @Autowired
      private CategoryService categoryService;

      // INDEX
      @GetMapping
      private String index(Model model, @RequestParam("edit") Optional<Integer> id) {
            model.addAttribute("categories", categoryService.getCategories());
            model.addAttribute("formCat", categoryService.catForm(id));
            return "/categories/index";
      }

      @PostMapping("/save")
      private String save(@Valid @ModelAttribute("formCat")Category formCategory, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
            if (bindingResult.hasErrors()) {
                  model.addAttribute("categories", categoryService.getCategories());
                  return "/categories/index";
            }
            categoryService.save(formCategory);
            redirectAttributes.addFlashAttribute("message", new Alert(AlertType.SUCCESS, "Categoria salvata correttamente"));
            return "redirect:/categories";
      }

      @PostMapping("/delete/{id}")
      private String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
            categoryService.delete(id);
            redirectAttributes.addFlashAttribute("message", new Alert(AlertType.SUCCESS, "Categoria eliminata correttamente"));
            return "redirect:/categories";
      }
}
