package com.lucasmurilo.loja.resources;

import com.lucasmurilo.loja.dominio.Product;
import com.lucasmurilo.loja.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService ProductService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = ProductService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = ProductService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product Product){
        Product = ProductService.insert(Product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Product.getId()).toUri();
        return ResponseEntity.created(uri).body(Product);

    }

}
