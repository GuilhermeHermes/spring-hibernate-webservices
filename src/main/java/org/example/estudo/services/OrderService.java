package org.example.estudo.services;

import org.example.estudo.entities.Order;
import org.example.estudo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();

    }

    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }
}
