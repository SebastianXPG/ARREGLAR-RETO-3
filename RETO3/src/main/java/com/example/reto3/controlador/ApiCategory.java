package com.example.reto3.controlador;

import com.example.reto3.entidad.Category;
import com.example.reto3.servicios.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/Category/")
@RestController
@CrossOrigin(origins = "*")
public class ApiCategory {
    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> getCategories(){
       return service.getCategories();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable long id){
        return service.getCategory(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody Category category){
        service.saveCategory(category);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id){
        service.deleteCategory(id);
        return ResponseEntity.status(204).build();}

}
