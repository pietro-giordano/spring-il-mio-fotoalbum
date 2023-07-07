package org.lessons.springilmiofotoalbum.service;

import org.lessons.springilmiofotoalbum.exceptions.CategoryNotFoundException;
import org.lessons.springilmiofotoalbum.model.Category;
import org.lessons.springilmiofotoalbum.model.Photo;
import org.lessons.springilmiofotoalbum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

      @Autowired
      private CategoryRepository categoryRepository;

      // metodo che restituisce categorie
      public List<Category> getCategories() {
            return categoryRepository.findAll();
      }

      // metodo che torna categoria per id
      public Category getCategoryById(Integer id) throws CategoryNotFoundException {
            Optional<Category> category = categoryRepository.findById(id);
            // se non esiste lancia eccezione
            if (category.isEmpty()) {
                  throw new CategoryNotFoundException();
            } else {
                  return category.get();
            }
      }

      // metodo che crea oggetto categoria per mappare form create/edit
      public Category catForm(Optional<Integer> id) {
            // inizializzo Category
            Category category;
            // se passo un id
            if (id.isPresent()) {
                  // verifico esistenza categoria su db con tale id e la recupero
                  Optional<Category> catData = Optional.ofNullable(getCategoryById(id.get()));
                  // se effettivamente esiste su db
                  if (catData.isPresent()) {
                        return catData.get();
                  } else {
                        // altrimenti
                        category = new Category();
                        return category;
                  }
            } else {
                  // se non passo id
                  category = new Category();
                  return category;
            }
      }

      // metodo che crea/updata categoria
      public Category save(Category formCategory) {
            Category newCategory = new Category();
            newCategory.setId(formCategory.getId());
            newCategory.setCreatedAt(LocalDateTime.now());
            newCategory.setName(formCategory.getName());
            newCategory.setPhotos(formCategory.getPhotos());
            return categoryRepository.save(newCategory);
      }

      // metodo che disassocia categorie a foto
      public void delete(Integer id) {
            Optional<Category> result = Optional.ofNullable(getCategoryById(id));
            // disassocio foto da categoria da cancellare
            for (Photo photo : result.get().getPhotos()) {
                  photo.getCategories().remove(result.get());
            }
            categoryRepository.deleteById(id);
      }
}
