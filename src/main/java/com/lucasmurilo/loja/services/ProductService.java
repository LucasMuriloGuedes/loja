package com.lucasmurilo.loja.services;

import com.lucasmurilo.loja.dominio.Product;
import com.lucasmurilo.loja.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = ProductRepository.findById(id);
        return obj.get();
    }

    public Product insert(Product Product){
        return ProductRepository.save(Product);
    }
}
