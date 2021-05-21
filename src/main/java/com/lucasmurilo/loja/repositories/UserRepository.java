package com.lucasmurilo.loja.repositories;

import com.lucasmurilo.loja.dominio.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
