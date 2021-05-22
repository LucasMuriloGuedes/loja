package com.lucasmurilo.loja.repositories;

import com.lucasmurilo.loja.dominio.Product;
import com.lucasmurilo.loja.dominio.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
