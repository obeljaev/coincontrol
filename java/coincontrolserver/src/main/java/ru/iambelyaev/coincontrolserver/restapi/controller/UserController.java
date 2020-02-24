package ru.iambelyaev.coincontrolserver.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.iambelyaev.coincontrolserver.restapi.model.Category;
import ru.iambelyaev.coincontrolserver.restapi.model.User;
import ru.iambelyaev.coincontrolserver.restapi.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @PostMapping(value = "/User")
    public ResponseEntity<?> create(@RequestBody User User) {
        System.out.println("@post /User");
        UserService.create(User);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/User")
    public ResponseEntity<List<User>> read() {
        final List<User> User = UserService.readAll();
        return User != null && !User.isEmpty()
                ? new ResponseEntity<>(User, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/Category/{id}")
//    public ResponseEntity<Category> read(@PathVariable(name = "id") int id) {
//        final Category Category = CategoryService.read(id);
//        return Category != null
//                ? new ResponseEntity<>(Category, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @PutMapping(value = "/Category/{id}")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Category Category) {
//        final boolean updated = CategoryService.update(Category, id);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

//    @DeleteMapping(value = "/Category/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
//        final boolean deleted = CategoryService.delete(id);
//
//        return deleted
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

}
