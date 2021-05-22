package com.lucasmurilo.loja.repositories;

import com.lucasmurilo.loja.dominio.OrdermItem;
import com.lucasmurilo.loja.dominio.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrdermItem, Long> {

}
