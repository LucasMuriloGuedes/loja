package com.lucasmurilo.loja.repositories;

import com.lucasmurilo.loja.dominio.Category;
import com.lucasmurilo.loja.dominio.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
