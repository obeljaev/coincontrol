package ru.iambelyaev.coincontolserver.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.iambelyaev.coincontolserver.restapi.model.Category;
import ru.iambelyaev.coincontolserver.restapi.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService CategoryService;

    @Autowired
    public CategoryController(CategoryService CategoryService) {
        this.CategoryService = CategoryService;
    }

    @PostMapping(value = "/Category")
    public ResponseEntity<?> create(@RequestBody Category Category) {
        CategoryService.create(Category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/Category")
    public ResponseEntity<List<Category>> read() {
        final List<Category> Category = CategoryService.readAll();
        return Category != null && !Category.isEmpty()
                ? new ResponseEntity<>(Category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/Category/{id}")
    public ResponseEntity<Category> read(@PathVariable(name = "id") int id) {
        final Category Category = CategoryService.read(id);
        return Category != null
                ? new ResponseEntity<>(Category, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/Category/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Category Category) {
        final boolean updated = CategoryService.update(Category, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/Category/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = CategoryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
