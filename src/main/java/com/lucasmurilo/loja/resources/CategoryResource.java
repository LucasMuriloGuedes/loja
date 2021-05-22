package com.lucasmurilo.loja.resources;

import com.lucasmurilo.loja.dominio.Category;
import com.lucasmurilo.loja.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService CategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = CategoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = CategoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category Category){
        Category = CategoryService.insert(Category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Category.getId()).toUri();
        return ResponseEntity.created(uri).body(Category);

    }

}
