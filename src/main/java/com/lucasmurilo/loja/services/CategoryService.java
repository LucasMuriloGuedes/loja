package com.lucasmurilo.loja.services;

import com.lucasmurilo.loja.dominio.Category;
import com.lucasmurilo.loja.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }

    public Category insert(Category Category){
        return CategoryRepository.save(Category);
    }
}
