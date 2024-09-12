package org.example.estudo.repositories;

import org.example.estudo.entities.OrderItem;
import org.example.estudo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
