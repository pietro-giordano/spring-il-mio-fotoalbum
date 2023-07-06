package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.model.Category;
import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

      @Autowired
      private CategoryRepository categoryRepository;

      // metodo che restituisce categorie
      public List<Category> getCategories() {
            return categoryRepository.findAll();
      }
}
